package com.jia.demo.activity;

import android.graphics.Color;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jakewharton.scalpel.ScalpelFrameLayout;
import com.jia.demo.R;

/**
 * 使用Scalpel显示3D立体布局
 */
public class ScalpelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View mainView = getLayoutInflater().inflate(R.layout.activity_scalpel, null);
        ScalpelFrameLayout mScalpelFrameLayout = new ScalpelFrameLayout(this);
        mScalpelFrameLayout.addView(mainView);
        mScalpelFrameLayout.setLayerInteractionEnabled(true); //开启 3D 效果
        //mScalpelFrameLayout.setDrawIds(true); //是否显示控件 id
        //mScalpelFrameLayout.setDrawViews(false); //是否展示控件内容，默认为 true
        mScalpelFrameLayout.setChromeColor(Color.RED); //修改边框颜色
        //mScalpelFrameLayout.setChromeShadowColor(Color.YELLOW); //修改阴影颜色
        setContentView(mScalpelFrameLayout);


    }

}

