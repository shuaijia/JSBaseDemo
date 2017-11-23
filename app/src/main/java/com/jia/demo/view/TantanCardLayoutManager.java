package com.jia.demo.view;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: 仿探探卡片效果的布局管理器
 * Created by jia on 2017/11/21.
 * 人之所以能，是相信能
 */
public class TantanCardLayoutManager extends RecyclerView.LayoutManager{

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        // 先移除所有view
        removeAllViews();

        // 在布局之前，将所有的子 View 先 Detach 掉，放入到 Scrap 缓存中
        detachAndScrapAttachedViews(recycler);

        int itemCount = getItemCount();
    }

    /**
     * 触摸事件
     */
    private View.OnTouchListener mOnTouchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
//            RecyclerView.ViewHolder childViewHolder = mRecyclerView.getChildViewHolder(v);
            return false;
        }
    };
}
