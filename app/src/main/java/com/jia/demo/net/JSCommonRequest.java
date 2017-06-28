package com.jia.demo.net;


import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Describtion:对OKhttp请求参数的封装
 * Created by jia on 2017/3/8 0008.
 * 人之所以能，是相信能
 */
public class JSCommonRequest {

    /**
     * 创建okhttp的get方法的请求封装类
     *
     * @param url
     * @param params
     * @return
     */
    public static Request createGetRequest(String url, HashMap<String, String> params) {

        StringBuilder urlBuilder = new StringBuilder(url).append("?");

        if (null != params) {

            // 遍历map集合，拼接url
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }

        return new Request.Builder()
                .url(urlBuilder.substring(0, urlBuilder.length() - 1)) // 将最后一个&去掉
                .get()
                .build();
    }


    /**
     * 创建okhttp的post方法的请求封装类
     *
     * @param url
     * @param params
     * @return
     */
    public static Request createPostRequest(String url, HashMap<String, String> params) {

        FormBody.Builder mFormBodybuilder = new FormBody.Builder();

        if (null != params) {
            // 遍历map集合，拼接url
            for (Map.Entry<String, String> entry : params.entrySet()) {
                mFormBodybuilder.add(entry.getKey(), entry.getValue());
            }
        }

        FormBody mFormBody = mFormBodybuilder.build();
        return new Request.Builder()
                .url(url)
                .post(mFormBody)
                .build();
    }
}
