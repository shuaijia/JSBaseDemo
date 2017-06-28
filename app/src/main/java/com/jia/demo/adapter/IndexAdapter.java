package com.jia.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.bean.IndexEntry;

import java.util.List;

/**
 * Describtion:索引recyclerView适配器
 * Created by jia on 2017/4/6 0006.
 * 人之所以能，是相信能
 */
public class IndexAdapter extends RecyclerView.Adapter {

    public static final int TYPE_INDEX = 0;
    public static final int TYPE_CONTENT = 1;

    private Context mContext;
    private List<IndexEntry> list;

    public IndexAdapter(Context mContext, List<IndexEntry> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_INDEX) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_index, parent, false);
            return new IndexViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_content, parent, false);
            return new ContentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_INDEX) {
            ((IndexViewHolder)holder).tvIndex.setText(list.get(position).getFirstWord()+"");
        } else {
            ((ContentViewHolder)holder).tvName.setText(list.get(position).getName()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).isIndex()) {
            return TYPE_INDEX;
        } else {
            return TYPE_CONTENT;
        }
    }

    private static class IndexViewHolder extends RecyclerView.ViewHolder {
        TextView tvIndex;

        IndexViewHolder(View itemView) {
            super(itemView);
            tvIndex = (TextView) itemView.findViewById(R.id.tv_index);
        }
    }

    private static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        ContentViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
