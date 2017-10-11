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
 * view变化
 */
public class AnimShareViewActivity extends Activity {

    private TextView tv_anim_share_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView方法之前，告诉Window页面切换需要动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_anim_share_view);

        tv_anim_share_view = (TextView) findViewById(R.id.tv_anim_share_view);
        tv_anim_share_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimShareViewActivity.this, AnimMainActivity.class), ActivityOptions.makeSceneTransitionAnimation(AnimShareViewActivity.this, tv_anim_share_view, "shareView").toBundle());
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
