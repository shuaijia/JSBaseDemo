package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.jia.demo.R;

public class AnimationActivity extends Activity {

    private TextView tv_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        tv_anim= (TextView) findViewById(R.id.tv_anim);

        YoYo.with(Techniques.Swing)
                .duration(700)
                .repeat(20)
                .pivotX(YoYo.CENTER_PIVOT)
                .playOn(findViewById(R.id.tv_anim));


    }
}
