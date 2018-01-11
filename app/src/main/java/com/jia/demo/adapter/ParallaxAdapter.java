package com.jia.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
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

        Glide.with(context)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515645221735&di=53676e8ea61db1a81386ddda2713c1ab&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F7c1ed21b0ef41bd5af9a14e85bda81cb38db3de4.jpg")
                .centerCrop()
                .into(((Holder)holder).iv);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    private class Holder extends RecyclerView.ViewHolder {

        public ImageView iv;

        Holder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
