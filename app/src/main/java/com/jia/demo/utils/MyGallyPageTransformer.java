package com.jia.demo.utils;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Describtion:
 * Created by jia on 2017/6/26.
 * 人之所以能，是相信能
 */
public class MyGallyPageTransformer implements ViewPager.PageTransformer {
    private static final float min_scale = 0.8f;
    @Override
    public void transformPage(View page, float position) {
        float scaleFactor = Math.max(min_scale, 1 - Math.abs(position));
        if (position < -1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else if (position < 0) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else if (position >= 0 && position < 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else if (position >= 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }
    }
}