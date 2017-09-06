package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jia.demo.R;
import com.jia.demo.view.miloading.MILoadingView;

public class MILoadingActivity extends Activity {

    private MILoadingView view_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miloading);
        view_loading= (MILoadingView) findViewById(R.id.view_loading);

        view_loading.startTranglesAnimation();

    }
}
