package com.jia.demo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.jia.demo.R;

/**
 * Describtion: 标签页
 * Created by jia on 2017/3/22 0022.
 * 人之所以能，是相信能
 */
public class TagActivity extends Activity {

    private FlexboxLayout flexbox_layout;

    private String[] resource = {"李健的歌", "父亲写的散文诗", "程序员", "旅行在路上", "梦醒时分", "青春", "娱乐八卦", "办公室", "笔记本", "JAVA", "小米"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        flexbox_layout = (FlexboxLayout) findViewById(R.id.flexbox_layout);


        for (int i = 0; i < resource.length; i++) {
            TextView tv = new TextView(TagActivity.this);
            tv.setBackgroundResource(R.drawable.shape_tag_item);
            tv.setTextColor(Color.GREEN);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(15.0f);
            tv.setPadding(15, 5, 15, 5);

            tv.setText(resource[i]);

            FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 80);
            lp.leftMargin = 8;
            lp.rightMargin = 8;
            lp.bottomMargin = 6;
            lp.topMargin=6;
            tv.setLayoutParams(lp);

            flexbox_layout.addView(tv);
        }

    }
}
