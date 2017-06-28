package com.jia.demo.download;

import android.content.Context;

import java.io.File;

/**
 * Describtion:下载信息实体类
 * Created by jia on 2017/4/24.
 * 人之所以能，是相信能
 */
public class DownloadEntry {

    //文件总长度
    public long fileSize;
    //下载链接
    public String downloadUrl;
    //线程Id
    public int threadId;
    //起始下载位置
    public long startLocation;
    //结束下载的文章
    public long endLocation;
    //下载文件
    public File tempFile;
    public Context context;

    public DownloadEntry(long fileSize, String downloadUrl, int threadId, long startLocation, long endLocation, File tempFile, Context context) {
        this.fileSize = fileSize;
        this.downloadUrl = downloadUrl;
        this.threadId = threadId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.tempFile = tempFile;
        this.context = context;
    }
}
