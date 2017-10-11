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
 * 爆炸式进入退出动画
 */
public class AnimExplodeActivity extends Activity {

    private TextView tv_anim_explode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView方法之前，告诉Window页面切换需要动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_anim_explode);

        tv_anim_explode= (TextView) findViewById(R.id.tv_anim_explode);
        tv_anim_explode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转
                startActivity(new Intent(AnimExplodeActivity.this, AnimMainActivity.class), ActivityOptions.makeSceneTransitionAnimation(AnimExplodeActivity.this).toBundle());
            }
        });

        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);

        //退出时使用
        getWindow().setExitTransition(explode);
        //第一次进入时使用
        getWindow().setEnterTransition(explode);
        //再次进入时使用
        getWindow().setReenterTransition(explode);
    }
}
