package com.jia.demo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.jia.demo.R;

public class ViewAnimationUtilsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_show1;
    private Button bt_show2;
    private Button bt_show3;
    private Button bt_show4;
    private CardView cv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_drag_button);
        initView();
    }

    private void initView() {
        bt_show1 = (Button) findViewById(R.id.bt_show1);
        bt_show2 = (Button) findViewById(R.id.bt_show2);
        bt_show3 = (Button) findViewById(R.id.bt_show3);
        bt_show4 = (Button) findViewById(R.id.bt_show4);
        cv_img = (CardView) findViewById(R.id.cv_img);

        bt_show1.setOnClickListener(this);
        bt_show2.setOnClickListener(this);
        bt_show3.setOnClickListener(this);
        bt_show4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 展示图片
            case R.id.bt_show1:

                cv_img.setVisibility(View.VISIBLE);

                break;
            // 斜线展示
            case R.id.bt_show2:

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Animator animator1 = ViewAnimationUtils.createCircularReveal(
                            cv_img, 0, 0, 0, (float) Math.hypot(cv_img.getWidth(), cv_img.getHeight()));
                    animator1.setInterpolator(new LinearInterpolator());//插补器有没有不影响
                    animator1.setDuration(2000);
                    animator1.start();
                }

                break;
            // 由内到外
            case R.id.bt_show3:

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    int cenX = cv_img.getWidth() / 2;
                    int cenY = cv_img.getHeight() / 2;
                    Animator an = ViewAnimationUtils.createCircularReveal(cv_img, cenX, cenY, 0, cenX);
                    an.setDuration(3000);
                    an.start();
                    an.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            cv_img.setVisibility(View.VISIBLE);
                        }
                    });
                }

                break;
            //由外到内
            case R.id.bt_show4:

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    int centerX = cv_img.getWidth() / 2;//获取组件的宽的一半
                    int centerY = cv_img.getHeight() / 2;//获取组件的高的一半
                    Animator animator = ViewAnimationUtils.createCircularReveal(cv_img, centerX, centerY, cv_img.getWidth(), 0);
                    animator.setDuration(3000);
                    animator.setInterpolator(new LinearOutSlowInInterpolator());//out到in
                    animator.start();
                    animator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            cv_img.setVisibility(View.GONE);
                        }
                    });
                }

                break;
            default:

        }
    }
}
