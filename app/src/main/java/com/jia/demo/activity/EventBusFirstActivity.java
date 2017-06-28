package com.jia.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.event.EventDemo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Describtion:
 * Created by jia on 2017/3/31 0031.
 * 人之所以能，是相信能
 */
public class EventBusFirstActivity extends Activity {

    private Button bt_event_first;
    private TextView tv_event_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_first);

        // 在接收事件的页面注册和解注册
        EventBus.getDefault().register(this);

        tv_event_first = (TextView) findViewById(R.id.tv_event_first);

        bt_event_first = (Button) findViewById(R.id.bt_event_first);
        bt_event_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到第二页
                startActivity(new Intent(EventBusFirstActivity.this, EventBusSecondActivity.class));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解注册
        EventBus.getDefault().unregister(this);
    }

    //接收消息
    @Subscribe
    public void onMessageEvent(EventDemo event) {
        tv_event_first.setText(event.getMsg() + "");
    }

    /**
     * =====================下面几个方法限制了处理消息在哪个线程===========================
     */
    //主线程中执行
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMainEventBus(EventDemo demo) {
//        tv_event_first.setText("ThreadMode.MAIN"+demo.getMsg());
//    }
//
//    //后台线程
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onBackgroundEventBus(EventDemo demo) {
//        tv_event_first.setText("ThreadMode.BACKGROUND"+demo.getMsg());
//    }
//
//    //异步线程
//    @Subscribe(threadMode = ThreadMode.ASYNC)
//    public void onAsyncEventBus(EventDemo demo) {
//        tv_event_first.setText("ThreadMode.ASYNC"+demo.getMsg());
//    }
//
//    //默认情况，和发送事件在同一个线程
//    @Subscribe(threadMode = ThreadMode.POSTING)
//    public void onPostEventBus(EventDemo demo) {
//        tv_event_first.setText("ThreadMode.POSTING"+demo.getMsg());
//    }

    /**
     * ====================也可以设置处理消息的优先级============================
     */
    //priority越大，级别越高
//    @Subscribe(priority = 1);
//    public void onEvent(EventDemo demo) {
//        tv_event_first.setText("ThreadMode.POSTING"+demo.getMsg());
//    }
}
