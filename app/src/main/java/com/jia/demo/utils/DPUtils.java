package com.jia.demo.utils;

import android.content.Context;

/**
 * Describtion:dp与px互转的工具类
 * Created by jia on 2017/5/10.
 * 人之所以能，是相信能
 */
public class DPUtils {
    public static int dp2px(Context context, int dpVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpVal * scale + 0.5f);
    }

    public static int sp2px(Context context, int spVal) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spVal * fontScale + 0.5f);
    }
}
