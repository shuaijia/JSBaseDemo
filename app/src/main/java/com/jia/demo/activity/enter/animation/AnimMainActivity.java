package com.jia.demo.activity.enter.animation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.jia.demo.R;

/**
 * Activity跳转动画
 */
public class AnimMainActivity extends Activity implements View.OnClickListener {

    private Button bt_anim_default;
    private Button bt_anim_explode;
    private Button bt_anim_slide;
    private Button bt_anim_share_view;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView方法之前，告诉Window页面切换需要动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_anim_main);

        mContext = AnimMainActivity.this;

        bt_anim_default = (Button) findViewById(R.id.bt_anim_default);
        bt_anim_default.setOnClickListener(this);
        bt_anim_explode= (Button) findViewById(R.id.bt_anim_explode);
        bt_anim_explode.setOnClickListener(this);
        bt_anim_slide= (Button) findViewById(R.id.bt_anim_slide);
        bt_anim_slide.setOnClickListener(this);
        bt_anim_share_view= (Button) findViewById(R.id.bt_anim_share_view);
        bt_anim_share_view.setOnClickListener(this);

//        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
//
//        //退出时使用
//        getWindow().setExitTransition(explode);
//        //第一次进入时使用
//        getWindow().setEnterTransition(explode);
//        //再次进入时使用
//        getWindow().setReenterTransition(explode);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_anim_default:

                // 跳转
                startActivity(new Intent(mContext, AnimDefaultActivity.class));

                break;
            case R.id.bt_anim_explode:

                // 跳转
                startActivity(new Intent(mContext, AnimExplodeActivity.class), ActivityOptions.makeSceneTransitionAnimation(AnimMainActivity.this).toBundle());

                break;
            case R.id.bt_anim_slide:

                // 跳转
                startActivity(new Intent(mContext, AnimSlideActivity.class), ActivityOptions.makeSceneTransitionAnimation(AnimMainActivity.this).toBundle());

                break;
            case R.id.bt_anim_share_view:

                startActivity(new Intent(mContext, AnimShareViewActivity.class), ActivityOptions.makeSceneTransitionAnimation(AnimMainActivity.this,bt_anim_share_view,"shareView").toBundle());

                break;
        }
    }
}
