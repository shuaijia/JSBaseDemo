package com.jia.demo.activity.swipeback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jia.demo.R;
import com.jia.demo.view.SwipeBackLayout;

public class SwipeBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_back);
        SwipeBackLayout mSwipeBackLayout = new SwipeBackLayout(this);
        mSwipeBackLayout.bind();
    }
}
