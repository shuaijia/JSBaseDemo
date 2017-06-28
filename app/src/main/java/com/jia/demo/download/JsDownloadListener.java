package com.jia.demo.download;

import java.net.HttpURLConnection;

/**
 * Describtion:下载回调
 * Created by jia on 2017/4/21.
 * 人之所以能，是相信能
 */
public interface JsDownloadListener {

    /**
     * 开始下载
     *
     * @param startLocation
     */
    public void onStart(long startLocation);

    /**
     * 恢复下载
     *
     * @param resumeLocation
     */
    public void onResume(long resumeLocation);

    /**
     * 停止下载
     *
     * @param stopLocation
     */
    public void onStop(long stopLocation);

    /**
     * 下载完成
     */
    public void onComplete();

    /**
     * 下载失败
     *
     * @param errorInfo 失败原因
     */
    public void onFail(String errorInfo);

    /**
     * 取消
     */
    public void onCancle();

    /**
     * 下载预处理,可通过HttpURLConnection获取文件长度
     *
     * @param conn
     */
    public void onPreDownload(HttpURLConnection conn);

    /**
     * 下载进度
     *
     * @param currentLocation 下载进度
     */
    public void onProgress(int currentLocation);

    /**
     * 单一线程下载完成
     *
     * @param finishLocation
     */
    public void onChildComplete(long finishLocation);

    /**
     * 子程恢复下载的位置
     *
     * @param resumeLocation
     */
    public void onChildResume(long resumeLocation);


}
