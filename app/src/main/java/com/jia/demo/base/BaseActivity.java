package com.jia.demo.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Describtion: Activity封装基类
 * Created by jia on 2017/3/17
 * 人之所以能，是相信能
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    /**
     * 类名
     */
    protected String className = getClass().getSimpleName() + "";

    /**
     * window管理器
     */
    protected WindowManager wm;

    /**
     * 屏幕宽度
     */
    protected int mScreenWidth = 0;

    /**
     * 屏幕高度
     */
    protected int mScreenHeight = 0;

    /**
     * 上下文
     */
    protected Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", className + "--onCreate: -----------------");

        // 去除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 锁定竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mContext = BaseActivity.this;


        // 图片的宽度
        // 图片的宽度
        wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        mScreenWidth = wm.getDefaultDisplay().getWidth();
        mScreenHeight = wm.getDefaultDisplay().getHeight();

        setContentView(setLayoutId());

        if(getIntent()!=null){
            dealIntent(getIntent());
        }

        initView();

        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", className + "--onResume: -----------------");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", className + "--onPause: -----------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", className + "--onStop: -----------------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", className + "--onDestroy: -----------------");
    }

    @Override
    public void onClick(View v) {
        onClick(v.getId());
    }


    /**
     * 返回布局id
     *
     * @return
     */
    public abstract int setLayoutId();

    /**
     * 处理获取到的Intent
     * @param intent
     */
    public abstract void dealIntent(Intent intent);

    /**
     * 初始化View
     * 进行findViewById
     */
    public abstract void initView();

    /**
     * 从网络获取数据
     */
    public abstract void initData();

    /**
     * 设置监听事件
     *
     * @param ViewId View的id
     */
    public abstract void onClick(int ViewId);
}
