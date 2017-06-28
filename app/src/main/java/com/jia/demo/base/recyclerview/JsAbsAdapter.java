package com.jia.demo.base.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Describtion: RecyclerView.Adapter的第一层封装,包含headerView/footerView等
 * Created by jia on 2017/3/17 0017.
 * 人之所以能，是相信能
 */
public abstract class JsAbsAdapter<M, VH extends JsBaseHolder> extends RecyclerView.Adapter<JsBaseHolder> {

    private static final String TAG = "JsAbsAdapter";

    public static final int VIEW_TYPE_HEADER = 1993;
    public static final int VIEW_TYPE_FOOTER = 1994;

    protected View headerView;
    protected View footerView;

    protected Context context;

    /**
     * 构造方法
     *
     * @param context 上下文
     */
    public JsAbsAdapter(Context context) {
        this.context = context;
    }


    @Override
    public JsBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // headView
        if (viewType == VIEW_TYPE_HEADER) {
            return new JsBaseHolder(headerView);
            // footView
        } else if (viewType == VIEW_TYPE_FOOTER) {
            return new JsBaseHolder(footerView);
        } else {
            return createCustomViewHolder(parent, viewType);
        }

    }

    @Override
    public void onBindViewHolder(JsBaseHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_HEADER:
            case VIEW_TYPE_FOOTER:
                break;
            default:
                bindCustomViewHolder((VH) holder, position);
                break;
        }
    }

    /**
     * 设置头布局headerView
     *
     * @param headerView
     */
    public void addHeaderView(View headerView) {
        if (headerView == null) {
            Log.w(TAG, "add the header view is null");
            return;
        }
        this.headerView = headerView;
        notifyDataSetChanged();
    }

    /**
     * 移除HeaderView
     */
    public void removeHeaderView() {
        if (headerView != null) {
            headerView = null;
            notifyDataSetChanged();
        }
    }

    /**
     * 设置尾布局footerView
     *
     * @param footerView
     */
    public void addFootView(View footerView) {
        if (footerView == null) {
            Log.w(TAG, "add the header view is null");
            return;
        }
        this.footerView = footerView;
        notifyDataSetChanged();
    }

    /**
     * 移除FooterView
     */
    public void removeFooterView() {
        if (footerView != null) {
            footerView = null;
            notifyDataSetChanged();
        }
    }

    /**
     * 获取附加View的数量,包括HeaderView和FooterView
     *
     * @return 数量
     */
    public int getExtraViewCount() {
        int extraViewCount = 0;
        if (headerView != null) {
            extraViewCount++;
        }
        if (footerView != null) {
            extraViewCount++;
        }
        return extraViewCount;
    }

    /**
     * 获取顶部附加View数量,即HeaderView数量
     *
     * @return 数量
     */
    public int getHeaderExtraViewCount() {
        return headerView == null ? 0 : 1;
    }

    /**
     * 获取底部附加View数量,即FooterView数量
     *
     * @return 数量, 0或1
     */
    public int getFooterExtraViewCount() {
        return footerView == null ? 0 : 1;
    }

    /**
     * 获取item的id
     *
     * @param position
     * @return
     */
    @Override
    public abstract long getItemId(int position);

    /**
     * 创建自定义的ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    public abstract VH createCustomViewHolder(ViewGroup parent, int viewType);

    /**
     * 绑定自定义的ViewHolder
     *     渲染数据到ViewHolder上
     * @param holder
     * @param position
     */
    public abstract void bindCustomViewHolder(VH holder, int position);

}
