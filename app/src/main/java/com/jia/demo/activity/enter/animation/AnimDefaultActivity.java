package com.jia.demo.activity.enter.animation;

import android.app.Activity;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jia.demo.R;

/**
 * 默认跳转动画
 */
public class AnimDefaultActivity extends Activity {

    private TextView tv_anim_default;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_default);

        tv_anim_default = (TextView) findViewById(R.id.tv_anim_default);

        tv_anim_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
