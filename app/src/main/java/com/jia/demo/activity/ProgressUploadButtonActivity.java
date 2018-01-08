package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.dd.CircularProgressButton;
import com.jia.demo.R;

/**
 * 上传进度 按钮
 */
public class ProgressUploadButtonActivity extends Activity{

    private CircularProgressButton bt1;
    private CircularProgressButton bt2;
    private CircularProgressButton bt3;

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

        bt1.setProgress(0);
        bt2.setProgress(0);
        bt3.setProgress(0);
    }

}
