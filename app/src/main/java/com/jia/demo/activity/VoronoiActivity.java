package com.jia.demo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.jia.demo.R;

import java.util.Random;

import quatja.com.vorolay.VoronoiView;

/**
 * 泰森多边形图
 */
public class VoronoiActivity extends Activity {

    private VoronoiView voronoi_view;

    private String[] colors = {"452ac1", "856745", "ac8754", "856a3b", "cb4521", "740012", "856965"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gao_si);
        voronoi_view = (VoronoiView) findViewById(R.id.voronoi_view);

        for (int i = 0; i < 10; i++) {
            ImageView view = new ImageView(this);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setBackgroundColor(Color.RED);
            if (i % 3 == 0) {
                view.setImageResource(R.mipmap.aa11);
            }else if(i % 3 == 1){
                view.setImageResource(R.mipmap.app_banner);
            }else{
                view.setImageResource(R.mipmap.course_default_bg);
            }

            voronoi_view.addView(view);
        }

    }
}
