package com.jia.demo.net;

/**
 * Describtion:需调用者实现具体操作的回调
 * Created by jia on 2017/3/8 0008.
 * 人之所以能，是相信能
 */
public interface JSListener {

    /**
     * 请求成功回调
     *
     * @param model 返回的实体类
     */
    void onSuccess(Object model);

    /**
     * 请求失败回调
     *
     * @param error 错误信息
     */
    void onFaile(String error);

}
