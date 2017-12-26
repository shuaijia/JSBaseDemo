package com.jia.demo.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.base.recyclerview.JsBaseHolder;

/**
 * Description: 首页 ViewHolder
 * Created by jia on 2017/3/17 0017.
 * 人之所以能，是相信能
 */
public class MyHolder extends JsBaseHolder {

    private TextView tv_item;

    public MyHolder(ViewGroup parent, @LayoutRes int resId) {
        super(parent, resId);

        tv_item= (TextView) itemView.findViewById(R.id.tv_item);
    }

    public TextView getTv_item() {
        return tv_item;
    }

    public void setTv_item(TextView tv_item) {
        this.tv_item = tv_item;
    }
}
