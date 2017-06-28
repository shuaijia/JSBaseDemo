package com.jia.demo.net;

import android.text.TextUtils;
import android.util.Log;

import com.jia.demo.base.BaseParser;
import com.jia.demo.bean.Login;

import java.util.HashMap;

/**
 * Describtion: 网络请求工具类
 * Created by jia on 2017/3/8 0008.
 * 人之所以能，是相信能
 */
public class NetWorkUtils {

    /**
     * @param url
     * @param params
     * @param listener
     */
    public static void get(String url, HashMap params, BaseParser mParser, JSListener listener) {

        JSCommonClient.sendRequest(JSCommonRequest.createGetRequest(url, params), new JSCommonCallback(listener, mParser));
    }

    public static void post(String url, HashMap params, BaseParser mParser, JSListener listener) {

        JSCommonClient.sendRequest(JSCommonRequest.createPostRequest(url, params), new JSCommonCallback(listener, mParser));
    }


    public static HashMap createParamsMap(String... args) {
        HashMap<String, String> map = new HashMap<String, String>();

        if (args.length % 2 != 0) {
            Log.e("Tag", "参数有误");
            return null;
        }

        for (int i = 0; i < args.length; i++) {
            if (!TextUtils.isEmpty(args[i]) && !TextUtils.isEmpty(args[i + 1])) {
                map.put(args[i], args[++i]);
            }

        }

        return map;
    }
}
