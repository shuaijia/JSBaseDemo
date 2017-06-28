package com.jia.demo.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description: OkHttpClient的封装
 * Created by jia on 2017/3/8 0008.
 * 人之所以能，是相信能
 */
public class JSCommonClient {

    // 请求超时时长
    private static final int TIME_OUT = 30;

    // okhttpClient对象
    private static OkHttpClient mOkHttpClient = null;

    static {
        OkHttpClient.Builder mBuidler = new OkHttpClient().newBuilder();

        // 设置各超时
        mBuidler.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        mBuidler.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        mBuidler.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        // 设置重定向 其实默认也是true
        mBuidler.followRedirects(true);

        /* 添加请求头 */
//        mBuidler.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request()
//                        .newBuilder()
//                        .addHeader("User-Agent", "Android—Mobile") // 标明发送本次请求的客户端
//                        .build();
//                return chain.proceed(request);
//            }
//        });


        /* 添加https支持 */
//        mBuidler.hostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String s, SSLSession sslSession) {
//                return true;
//            }
//        });
//        mBuidler.sslSocketFactory(HttpsUtils.initSSLSocketFactory(),HttpsUtils.initTrustManager());


        // 创建okhttpClient对象
        mOkHttpClient = mBuidler.build();

    }

    /**
     * 发送请求
     *
     * @param request
     * @param callback
     * @return
     */
    public static Call sendRequest(Request request, Callback callback) {
        Call mCall = mOkHttpClient.newCall(request);
        mCall.enqueue(callback);
        return mCall;
    }

}
