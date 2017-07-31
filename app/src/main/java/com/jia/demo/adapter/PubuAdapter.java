package com.jia.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jia.demo.R;

import java.util.List;

/**
 * Describtion:
 * Created by jia on 2017/6/22.
 * 人之所以能，是相信能
 */
public class PubuAdapter extends RecyclerView.Adapter<PubuAdapter.MasonryView> {
    private List<String> products;
    private Context context;

    public PubuAdapter(List<String> list, Context context) {
        products = list;
        this.context = context;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        Glide.with(context)
                .load(products.get(position))
                .into(masonryView.imageView);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MasonryView extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MasonryView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_recycler_img);
        }

    }

}