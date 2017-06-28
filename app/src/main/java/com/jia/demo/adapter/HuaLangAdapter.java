package com.jia.demo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Describtion:
 * Created by jia on 2017/6/26.
 * 人之所以能，是相信能
 */
public class HuaLangAdapter extends PagerAdapter {
    private List<String> myInfoLists;
    private Context context;
    private int xinWidth;
    private int xinHeight;

    public HuaLangAdapter(List<String> myInfoLists, Context context) {
        this.context=context;
        this.myInfoLists=myInfoLists;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView vp_iv= new ImageView(context);
        Glide.with(context).load(myInfoLists.get(position%myInfoLists.size())).into(vp_iv);
        container.addView(vp_iv);
        return vp_iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}