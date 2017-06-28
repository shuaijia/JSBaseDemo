package com.jia.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jia.demo.R;

/**
 * Describtion: 折叠效果RecyclerView的Adapter
 * Created by jia on 2017/3/30 0030.
 * 人之所以能，是相信能
 */
public class ParallaxAdapter extends RecyclerView.Adapter {
    private Context context;

    public ParallaxAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_parallax, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    private class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView);
        }

    }
}
