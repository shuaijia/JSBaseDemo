package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jia.demo.R;
import com.jia.demo.adapter.ParallaxAdapter;
import com.jia.demo.view.JsParallaxRecyclerView;

/**
 * Describtion:
 * Created by jia on 2017/3/30 0030.
 * 人之所以能，是相信能
 */
public class ParallaxActivity extends Activity {

    private JsParallaxRecyclerView rv_parallax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_parallax);

        rv_parallax= (JsParallaxRecyclerView) findViewById(R.id.rv_parallax);

        rv_parallax.setAdapter(new ParallaxAdapter(ParallaxActivity.this));
    }
}
