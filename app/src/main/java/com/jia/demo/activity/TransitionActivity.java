package com.jia.demo.activity;

import android.os.Bundle;
import android.support.transition.AutoTransition;
import android.support.transition.Fade;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jia.demo.R;

/**
 * 过度动画 界面
 * <p>
 * 相关博客：https://juejin.im/post/5ae057e46fb9a07aa83e6828
 */
public class TransitionActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bt_start;
    private ImageView iv_anim;
    private RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        initView();
    }

    private void initView() {
        bt_start = (Button) findViewById(R.id.bt_start);
        iv_anim = (ImageView) findViewById(R.id.iv_anim);
        rl_root = (RelativeLayout) findViewById(R.id.rl_root);

        bt_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:

                Fade fade = new Fade();
                AutoTransition auto=new AutoTransition();
                TransitionManager.beginDelayedTransition(rl_root, auto);

                if (iv_anim.getVisibility() == View.VISIBLE) {
                    iv_anim.setVisibility(View.GONE);
                } else {
                    iv_anim.setVisibility(View.VISIBLE);
                }

                break;
        }
    }
}
