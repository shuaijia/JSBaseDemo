package com.jia.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jia.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Describtion:
 * Created by jia on 2017/8/3.
 * 人之所以能，是相信能
 */
public class ItemAnimAdapter extends RecyclerView.Adapter<ItemAnimAdapter.ViewHolder> {

    private Context context;
    private List<String> list = new ArrayList<>();

    private int position = 0;

    public ItemAnimAdapter(Context context) {
        this.context = context;
    }

    public void addData() {
        list.add("第" + (list.size() + 1) + "条数据");
        notifyItemInserted(list.size());

    }

    public void deleteData() {
        if (list.size() >= 0) {
            list.remove(0);
//            notifyItemRemoved(list.size());
            notifyItemRemoved(0);
        }
    }

    public void updateData() {
        if (list.size() > 0) {
            list.set(list.size() - 1, "我爱北京");
            notifyDataSetChanged();
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_animator, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_animator_content.setText(list.get(position) + "");
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_animator_content;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_animator_content = (TextView) itemView.findViewById(R.id.tv_animator_content);
        }
    }
}
