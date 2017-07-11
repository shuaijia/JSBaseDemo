package com.jia.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jia.demo.R;

/**
 * Describtion:
 * Created by jia on 2017/7/11.
 * 人之所以能，是相信能
 */
public class StatusBarActivity extends Activity {

    private TextView tv_status_theme;
    private TextView tv_status_view_hight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);


    }
}
