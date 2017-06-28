package com.jia.demo.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.jia.demo.R;
import com.jia.demo.base.BaseActivity;
import com.jia.demo.view.JsCircleProgressBar;
import com.jia.demo.view.JsHorizontalProgressBarWithNum;

/**
 * Describtion: 原形进度条界面
 * Created by jia on 2017/4/18.
 * 人之所以能，是相信能
 */
public class CircularProgressActivity extends BaseActivity {

    private JsHorizontalProgressBarWithNum pb;
    private JsCircleProgressBar pb_circle;

    private int pro=0;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                pb.setProgress(pro++);
//                pb_circle.setProgress(pro++);
                handler.sendEmptyMessageDelayed(0,160);
            }
        }
    };

    @Override
    public int setLayoutId() {
        return R.layout.activity_progressbar;
    }

    @Override
    public void dealIntent(Intent intent) {

    }

    @Override
    public void initView() {
        pb= (JsHorizontalProgressBarWithNum) findViewById(R.id.pb_hori_num);
        pb_circle= (JsCircleProgressBar) findViewById(R.id.pb_circle);
        handler.sendEmptyMessageDelayed(0,500);
        pb_circle.setProgress(100);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(int ViewId) {

    }
}
