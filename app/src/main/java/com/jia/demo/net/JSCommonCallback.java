package com.jia.demo.net;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.jia.demo.base.BaseModel;
import com.jia.demo.base.BaseParser;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Describtion:请求回调
 * Created by jia on 2017/3/8 0008.
 * 人之所以能，是相信能
 */
public class JSCommonCallback<T> implements Callback {

    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHER_ERROR = -3;

    /**
     * 将其它线程的数据转发到UI线程
     */
    private Handler mHandler;
    private JSListener mListener;
    private BaseParser<T> mParser;

    public JSCommonCallback(JSListener mListener, BaseParser<T> mParser) {
        this.mListener = mListener;
        mHandler = new Handler();
        this.mParser=mParser;
    }


    @Override
    public void onFailure(Call call, final IOException e) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFaile("网络错误");
            }
        });

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        // 返回的json串
        String result = response.body().string();

        if (TextUtils.isEmpty(result)) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mListener.onFaile("服务器错误");
                }
            });
        } else {

            final Object obj=mParser.parseJSON(result);

            if (obj == null) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListener.onFaile("解析异常");
                    }
                });
            } else {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListener.onSuccess(obj);
                    }
                });
            }


        }


    }
}
