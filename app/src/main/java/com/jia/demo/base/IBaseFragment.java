package com.jia.demo.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Describtion: 基础的Fragment接口
 * 用于定义Fragment操作相关方法
 * Created by jia on 2017/3/22
 * 人之所以能，是相信能
 */
public interface IBaseFragment {

    /**
     * 返回ContentView的布局资源id
     *
     * @return
     */
    @LayoutRes
    int getCreateViewId();

    /**
     * 此方法用于初始化成员变量及获取Intent传递过来的数据
     * 注意：这个方法中不能调用所有的View，因为View还没有被初始化，要使用View在initView方法中调用
     */
    void initData();

    /**
     * 进行findViewById操作
     *
     * @param inflateView
     * @param savedInstanceState
     */
    void findView(View inflateView, Bundle savedInstanceState);

    /**
     * 渲染数据到View
     *
     * @param inflateView
     * @param savedInstanceState
     */
    void initView(View inflateView, Bundle savedInstanceState);

    /**
     * 设置监听事件
     */
    void initListener();

    /**
     * 初始化对话框
     */
    void initDialog();
}
