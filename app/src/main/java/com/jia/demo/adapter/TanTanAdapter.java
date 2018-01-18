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
 * Description:
 * Created by jia on 2018/1/18.
 * 人之所以能，是相信能
 */
public class TanTanAdapter extends RecyclerView.Adapter<TanTanAdapter.TanTanViewHolder> {

    private Context context;

    private List<String> list;

    public TanTanAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public TanTanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_tantan, parent, false);
        return new TanTanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TanTanViewHolder holder, int position) {

        Glide.with(context)
                .load(list.get(position))
                .centerCrop()
                .crossFade()
                .into(holder.iv_tantan);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class TanTanViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_tantan;

        public TanTanViewHolder(View itemView) {
            super(itemView);
            iv_tantan = (ImageView) itemView.findViewById(R.id.iv_tantan);
        }
    }
}
