package com.jia.demo.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;

import com.jia.demo.R;

public class Transition2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);// 允许使用transitions

        setContentView(R.layout.activity_transition2);

        //进入动画
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Fade().setDuration(1000).setInterpolator(new AccelerateInterpolator()));
            getWindow().setReturnTransition(new Explode().setDuration(1000));
        }

    }
}
