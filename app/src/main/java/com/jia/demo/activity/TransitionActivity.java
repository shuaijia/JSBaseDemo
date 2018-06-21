package com.jia.demo.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jia.demo.R;

/**
 * 过渡动画
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
                Intent intent = new Intent(this, Transition2Activity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, iv_anim, "head").toBundle());
                } else {
                    startActivity(intent);
                }

                break;
        }
    }
}
