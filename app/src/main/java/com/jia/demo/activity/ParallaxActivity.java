package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

import com.bumptech.glide.Glide;
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

        rv_parallax.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                switch (newState){
                    // 停止滑动
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:

                        Glide.with(ParallaxActivity.this).resumeRequests();

                        break;
                    // 快速滑动中
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:

                        Glide.with(ParallaxActivity.this).pauseRequests();

                        break;
                    // 手指触摸滑动开始
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:


                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
