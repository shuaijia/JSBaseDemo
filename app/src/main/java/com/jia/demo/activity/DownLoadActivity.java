package com.jia.demo.activity;

import android.content.Intent;
import android.util.Log;

import com.jia.demo.base.BaseActivity;
import com.jia.demo.download.DownloadUtils;
import com.jia.demo.download.JsDownloadListener;

import java.net.HttpURLConnection;

/**
 * Describtion: 多线程下载，断点续传
 * Created by jia on 2017/4/19.
 * 人之所以能，是相信能
 */
public class DownLoadActivity extends BaseActivity {

    private String TAG="DownLoadActivity";

    @Override
    public int setLayoutId() {
        return 0;
    }

    @Override
    public void dealIntent(Intent intent) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        DownloadUtils.getInstance().download(mContext, "url", "path", new JsDownloadListener() {
            @Override
            public void onStart(long startLocation) {
                Log.e(TAG, "onStart: "+startLocation );
            }

            @Override
            public void onResume(long resumeLocation) {
                Log.e(TAG, "onResume: "+resumeLocation);
            }

            @Override
            public void onStop(long stopLocation) {
                Log.e(TAG, "onStop: "+stopLocation);
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");
            }

            @Override
            public void onFail(String errorInfo) {
                Log.e(TAG, "onFail: ");
            }

            @Override
            public void onCancle() {
                Log.e(TAG, "onCancle: ");
            }

            @Override
            public void onPreDownload(HttpURLConnection conn) {
                Log.e(TAG, "onPreDownload: ");
            }

            @Override
            public void onProgress(int currentLocation) {
                Log.e(TAG, "onProgress: "+ currentLocation);
            }

            @Override
            public void onChildComplete(long finishLocation) {
                Log.e(TAG, "onChildComplete: ");
            }

            @Override
            public void onChildResume(long resumeLocation) {
                Log.e(TAG, "onChildResume: ");
            }
        });
    }

    @Override
    public void onClick(int ViewId) {

    }
}
