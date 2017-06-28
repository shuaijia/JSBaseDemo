package com.jia.demo.download;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

/**
 * Describtion:下载工具类
 * Created by jia on 2017/4/24.
 * 人之所以能，是相信能
 */
public class DownloadUtils {

    private static final String TAG = "DownloadUtils";

    // 连接超时
    private final int TIME_OUT = 5000;

    // 下载线程数
    private int THREAD_NUM = 3;

    // 是否取消
    private boolean isCancel;

    // 是否停止
    private boolean isStop;

    // 是否正在下载
    private boolean isDownloading = false;

    // 取消线程数
    private int mCancelNum;

    // 停止线程数
    private int mStopNum;

    // 完成线程数
    private int mCompleteThreadNum;

    // 当前下载位置
    private int mCurrentLocation;

    // 下载回调
    private JsDownloadListener mListener;

    // 下载地址
    private String downloadUrl;

    // 下载文件地址
    private String filePath;

    // 上下文
    private Context context;


    // 新的下载
    private boolean newTask;

    private static DownloadUtils mDownloadUtils;

    private DownloadUtils() {
    }


    public static DownloadUtils getInstance() {
        if (mDownloadUtils == null) {
            mDownloadUtils = new DownloadUtils();
        }
        return mDownloadUtils;
    }

    /**
     * 下载方法
     *
     * @param context
     * @param downloadUrl
     * @param filePath
     * @param downloadListener
     */
    public void download(final Context context, @NonNull final String downloadUrl, @NonNull final String filePath,
                         @NonNull final JsDownloadListener downloadListener) {
        this.downloadUrl = downloadUrl;
        this.filePath = filePath;
        this.context = context;
        isDownloading = true;
        mCurrentLocation = 0;
        isStop = false;
        isCancel = false;
        mCancelNum = 0;
        mStopNum = 0;
        final File dFile = new File(filePath);

        //读取已完成的线程数
        final File configFile = new File(context.getFilesDir().getPath() + "/temp/" + dFile.getName() + ".properties");
        try {
            if (!configFile.exists()) { //记录文件被删除，则重新下载
                newTask = true;
//                FileUtil.createFile(configFile.getPath());
            } else {
                newTask = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            mListener.onFail("文件操作异常");
            return;
        }
        newTask = !dFile.exists();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mListener = downloadListener;
                    URL url = new URL(downloadUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Charset", "UTF-8");
                    conn.setConnectTimeout(TIME_OUT);
                    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
                    conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
                    conn.connect();
                    //网络被劫持时会出现这个问题
                    if (conn.getContentLength() < 0) {
                        mListener.onFail("网络数据错误");
                        return;
                    }
                    int code = conn.getResponseCode();
                    if (code == 200) {
                        int fileLength = conn.getContentLength();
                        //必须建一个文件
//                        FileUtil.createFile(filePath);
                        RandomAccessFile file = new RandomAccessFile(filePath, "rwd");
                        //设置文件长度
                        file.setLength(fileLength);
                        mListener.onPreDownload(conn);
                        //分配每条线程的下载区间
                        Properties pro = null;
//                        pro = Util.loadConfig(configFile);
                        int blockSize = fileLength / THREAD_NUM;
                        SparseArray<Thread> tasks = new SparseArray<>();
                        for (int i = 0; i < THREAD_NUM; i++) {
                            long startL = i * blockSize, endL = (i + 1) * blockSize;
                            Object state = pro.getProperty(dFile.getName() + "_state_" + i);
                            if (state != null && Integer.parseInt(state + "") == 1) {  //该线程已经完成
                                mCurrentLocation += endL - startL;
                                Log.d(TAG, "++++++++++ 线程_" + i + "_已经下载完成 ++++++++++");
                                mCompleteThreadNum++;
                                if (mCompleteThreadNum == THREAD_NUM) {
                                    if (configFile.exists()) {
                                        configFile.delete();
                                    }
                                    mListener.onComplete();
                                    isDownloading = false;
                                    System.gc();
                                    return;
                                }
                                continue;
                            }
                            //分配下载位置
                            Object record = pro.getProperty(dFile.getName() + "_record_" + i);
                            if (!newTask && record != null && Long.parseLong(record + "") > 0) {       //如果有记录，则恢复下载
                                Long r = Long.parseLong(record + "");
                                mCurrentLocation += r - startL;
                                Log.d(TAG, "++++++++++ 线程_" + i + "_恢复下载 ++++++++++");
                                mListener.onChildResume(r);
                                startL = r;
                            }
                            if (i == (THREAD_NUM - 1)) {
                                endL = fileLength;//如果整个文件的大小不为线程个数的整数倍，则最后一个线程的结束位置即为文件的总长度
                            }
                            DownloadEntry entity = new DownloadEntry(fileLength, downloadUrl, i, startL, endL, dFile, context);
                            DownLoadTask task = new DownLoadTask(entity);
                            tasks.put(i, new Thread(task));
                        }
                        if (mCurrentLocation > 0) {
                            mListener.onResume(mCurrentLocation);
                        } else {
                            mListener.onStart(mCurrentLocation);
                        }
                        for (int i = 0, count = tasks.size(); i < count; i++) {
                            Thread task = tasks.get(i);
                            if (task != null) {
                                task.start();
                            }
                        }
                    } else {
                        Log.e(TAG, "下载失败，返回码：" + code);
                        isDownloading = false;
                        System.gc();
                        mListener.onFail("返回码" + code);
                    }
                } catch (IOException e) {
//                    Log.e(this, "下载失败【downloadUrl:" + downloadUrl + "】\n【filePath:" + filePath + "】" + FL.getPrintException(e));
                    isDownloading = false;
                    mListener.onFail("数据流错误");
                }
            }
        }).start();
    }

    /**
     * 下载任务
     */
    private class DownLoadTask implements Runnable {

        private static final String TAG = "DownLoadTask";
        private DownloadEntry mDownloadEntry;
        private String configFPath;

        public DownLoadTask(DownloadEntry mDownloadEntry) {
            this.mDownloadEntry = mDownloadEntry;
            configFPath = mDownloadEntry.context.getFilesDir().getPath() + "/temp/" + mDownloadEntry.tempFile.getName() + ".properties";
        }

        @Override
        public void run() {

            URL url = null;
            try {
                url = new URL(mDownloadEntry.downloadUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //在头里面请求下载开始位置和结束位置
                conn.setRequestProperty("Range", "bytes=" + mDownloadEntry.startLocation + "-" + mDownloadEntry.endLocation);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Charset", "UTF-8");
                conn.setConnectTimeout(TIME_OUT);
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
                conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
                conn.setReadTimeout(3000);  //设置读取流的等待时间,必须设置该参数
                InputStream is = conn.getInputStream();
                //创建可设置位置的文件
                RandomAccessFile file = new RandomAccessFile(mDownloadEntry.tempFile, "rwd");
                //设置每条线程写入文件的位置
                file.seek(mDownloadEntry.startLocation);
                byte[] buffer = new byte[1024];
                int len;
                //当前子线程的下载位置
                long currentLocation = mDownloadEntry.startLocation;

                while ((len = is.read(buffer)) != -1) {
                    if (isCancel) {
                        Log.d(TAG, "++++++++++ thread_" + mDownloadEntry.threadId + "_cancel ++++++++++");
                        break;
                    }

                    if (isStop) {
                        break;
                    }

                    //把下载数据数据写入文件
                    file.write(buffer, 0, len);
                    synchronized (DownloadUtils.this) {
                        mCurrentLocation += len;
                        mListener.onProgress(mCurrentLocation);
                    }
                    currentLocation += len;
                }
                file.close();
                is.close();

                if (isCancel) {
                    synchronized (DownloadUtils.this) {
                        mCancelNum++;
                        if (mCancelNum == THREAD_NUM) {
                            File configFile = new File(configFPath);
                            if (configFile.exists()) {
                                configFile.delete();
                            }

                            if (mDownloadEntry.tempFile.exists()) {
                                mDownloadEntry.tempFile.delete();
                            }
                            Log.d(TAG, "++++++++++++++++ onCancel +++++++++++++++++");
                            isDownloading = false;
                            mListener.onCancle();
                            System.gc();
                        }
                    }
                    return;
                }

                //停止状态不需要删除记录文件
                if (isStop) {
                    synchronized (DownloadUtils.this) {
                        mStopNum++;
                        String location = String.valueOf(currentLocation);
                        Log.i(TAG, "thread_" + mDownloadEntry.threadId + "_stop, stop location ==> " + currentLocation);
//                        writeConfig(mDownloadEntry.tempFile.getName() + "_record_" + mDownloadEntry.threadId, location);
                        if (mStopNum == THREAD_NUM) {
                            Log.d(TAG, "++++++++++++++++ onStop +++++++++++++++++");
                            isDownloading = false;
                            mListener.onStop(mCurrentLocation);
                            System.gc();
                        }
                    }
                    return;
                }

                Log.i(TAG, "线程【" + mDownloadEntry.threadId + "】下载完毕");
//                writeConfig(mDownloadEntry.tempFile.getName() + "_state_" + mDownloadEntry.threadId, 1 + "");
                mListener.onChildComplete(mDownloadEntry.endLocation);
                mCompleteThreadNum++;
                if (mCompleteThreadNum == THREAD_NUM) {
                    File configFile = new File(configFPath);
                    if (configFile.exists()) {
                        configFile.delete();
                    }
                    mListener.onComplete();
                    isDownloading = false;
                    System.gc();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
                isDownloading = false;
                mListener.onFail("url有误");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                isDownloading = false;
                mListener.onFail("文件没找到");
            } catch (ProtocolException e) {
                e.printStackTrace();
                isDownloading = false;
                mListener.onFail("请求类型错误");
            } catch (IOException e) {
                e.printStackTrace();
                isDownloading = false;
                mListener.onFail("数据流错误");
            }


        }
    }

    /**
     * 取消下载
     */
    public void cancle() {
        this.isCancel = true;
    }

    /**
     * 暂停下载
     */
    public void stop() {
        this.isStop = true;
    }

    /**
     * 恢复下载
     *
     * @return
     */
    public boolean resume() {
        if (TextUtils.isEmpty(downloadUrl)) {
            return false;
        } else {
            download(context, downloadUrl, filePath, mListener);
            return true;
        }
    }
}
