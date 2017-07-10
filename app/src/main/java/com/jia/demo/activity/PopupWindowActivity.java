package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.view.CustomPopWindow;

/**
 * 封装破pupWindow界面
 */
public class PopupWindowActivity extends Activity {

    private TextView tv_target1;
    private TextView tv_target2;


    private RelativeLayout rl_pop_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        rl_pop_root = (RelativeLayout) findViewById(R.id.rl_pop_root);
        tv_target1 = (TextView) findViewById(R.id.tv_target1);
        tv_target2 = (TextView) findViewById(R.id.tv_target2);

        tv_target1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWinAtLocation();
            }
        });

        tv_target2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWinAsLocation();
            }
        });

    }

    private void showPopWinAtLocation() {
        CustomPopWindow popWindow = new CustomPopWindow.Builder()
                .setContentViewId(R.layout.dialog_popupwindow)
                .setContext(PopupWindowActivity.this)
                .setOutSideCancle(true)
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setAnimation(R.style.anim_pop)
                .build()
                .showAtLocation(rl_pop_root, Gravity.TOP | Gravity.CENTER, 0, 0);


    }

    private void showPopWinAsLocation() {
        CustomPopWindow popWindow = new CustomPopWindow.Builder()
                .setContentViewId(R.layout.dialog_popupwindow)
                .setContext(PopupWindowActivity.this)
                .setOutSideCancle(true)
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setAnimation(R.style.anim_pop)
                .build()
                .showAsLocation(tv_target2, Gravity.BOTTOM | Gravity.CENTER, 0, 0);
    }
}
