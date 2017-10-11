package com.jia.demo.activity.enter.animation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.jia.demo.R;

/**
 * 侧滑动画界面
 */
public class AnimSlideActivity extends Activity {

    private TextView tv_anim_slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView方法之前，告诉Window页面切换需要动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_anim_slide);

        tv_anim_slide= (TextView) findViewById(R.id.tv_anim_slide);
        tv_anim_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转
                startActivity(new Intent(AnimSlideActivity.this, AnimMainActivity.class), ActivityOptions.makeSceneTransitionAnimation(AnimSlideActivity.this).toBundle());
            }
        });

        Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.slide);

        //退出时使用
        getWindow().setExitTransition(slide);
        //第一次进入时使用
        getWindow().setEnterTransition(slide);
        //再次进入时使用
        getWindow().setReenterTransition(slide);
    }
}
