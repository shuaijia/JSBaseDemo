package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;

import com.dd.CircularProgressButton;
import com.jia.demo.R;

/**
 * 上传进度 按钮
 */

public class ProgressUploadButtonActivity extends Activity implements View.OnClickListener {

    private CircularProgressButton bt1;
    private CircularProgressButton bt2;
    private CircularProgressButton bt3;

    private int num1 = 0;
    private int num2 = 0;
    private int num3 = 0;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 11:
                    num1 += 30;
                    if (num1 < 100) {
                        bt1.setProgress(num1);
                        handler.sendEmptyMessageDelayed(11, 400);
                    } else {
                        bt1.setProgress(100);
                    }

                    break;
                case 22:
                    num2 += 30;
                    if (num2 < 100) {
                        bt2.setProgress(num2);
                        handler.sendEmptyMessageDelayed(22, 400);
                    } else {
                        bt2.setProgress(-1);
                    }

                    break;
                case 33:
                    num3 += 30;
                    if (num3 < 100) {
                        bt3.setProgress(num3);
                        handler.sendEmptyMessageDelayed(33, 400);
                    } else {
                        bt3.setProgress(100);
                    }

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_upload_button);
        initView();
    }

    private void initView() {
        bt1 = (CircularProgressButton) findViewById(R.id.bt1);
        bt2 = (CircularProgressButton) findViewById(R.id.bt2);
        bt3 = (CircularProgressButton) findViewById(R.id.bt3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        bt1.setProgress(0);
        bt2.setProgress(0);
        bt3.setProgress(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                handler.sendEmptyMessageDelayed(11, 400);
                break;
            case R.id.bt2:
                handler.sendEmptyMessageDelayed(22, 400);
                break;
            case R.id.bt3:
                handler.sendEmptyMessageDelayed(33, 400);
                break;
        }
    }


}
