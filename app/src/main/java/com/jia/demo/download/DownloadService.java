package com.jia.demo.download;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Describtion:
 * Created by jia on 2017/7/10.
 * 人之所以能，是相信能
 */
public interface DownloadService {

    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String url);

}
