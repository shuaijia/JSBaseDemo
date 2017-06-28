package com.jia.demo.adapter;


import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.jia.demo.R;
import com.jia.demo.base.recyclerview.JsBaseAdapter;
import com.jia.demo.bean.Login;

import java.util.List;


/**
 * Describtion:
 * Created by jia on 2017/3/17 0017.
 * 人之所以能，是相信能
 */
public class MyAdapter extends JsBaseAdapter<Login,MyHolder> {


    public MyAdapter(Context context) {
        super(context);
    }

    public MyAdapter(Context context, List<Login> dataList) {
        super(context, dataList);
    }

    @Override
    public int getCustomViewType(int position) {
        return 0;
    }

    @Override
    public MyHolder createCustomViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(parent, R.layout.item_my_rv);
    }

    @Override
    public void bindCustomViewHolder(MyHolder holder, int position) {
        holder.getTv_item().setText(dataList.get(position).getNote()+"");
    }


}
