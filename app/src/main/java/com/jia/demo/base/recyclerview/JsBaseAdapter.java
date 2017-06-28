package com.jia.demo.base.recyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Describtion:RecyclerView.Adapter的第二层封装
 * Created by jia on 2017/3/17 0017.
 * 人之所以能，是相信能
 */
public abstract class JsBaseAdapter<M, VH extends JsBaseHolder> extends JsAbsAdapter<M, VH> {

    protected List<M> dataList;

    /**
     * 构造方法
     *
     * @param context 上下文
     */
    public JsBaseAdapter(Context context) {
        super(context);
    }

    /**
     * 构造方法
     *
     * @param context  上下文
     * @param dataList 资源
     */
    public JsBaseAdapter(Context context, List<M> dataList) {
        super(context);
        this.dataList = new ArrayList<M>();
        this.dataList.addAll(dataList);
    }

    /**
     * 更换数据
     * 此操作会清除原来的数据
     *
     * @param mList
     * @return 更换成功并刷新界面
     */
    public boolean fillList(List<M> mList) {
        dataList.clear();
        boolean isFillAll = dataList.addAll(mList);
        if (isFillAll) {
            notifyDataSetChanged();
        }
        return isFillAll;
    }

    /**
     * 追加一条数据
     *
     * @param model
     * @return 追加成功并刷新界面
     */
    public boolean appendItem(M model) {
        boolean result = dataList.add(model);
        if (result) {
            if (getHeaderExtraViewCount() == 0) {
                notifyItemInserted(dataList.size() - 1);
            } else {
                notifyItemInserted(dataList.size());
            }
        }
        return result;
    }

    /**
     * 追加一串数据
     *
     * @param mList
     * @return 追加成功并刷新界面
     */
    public boolean appendList(List<M> mList) {
        boolean result = dataList.addAll(mList);
        if (result) {
            notifyDataSetChanged();
        }
        return result;
    }

    /**
     * 在最顶部前置数据
     *
     * @param data 要前置的数据
     */
    public void proposeItem(M data) {
        dataList.add(0, data);
        if (getHeaderExtraViewCount() == 0) {
            notifyItemInserted(0);
        } else {
            notifyItemInserted(getHeaderExtraViewCount());
        }
    }

    /**
     * 在顶部前置数据集合
     *
     * @param list 要前置的数据集合
     */
    public void proposeList(List<M> list) {
        dataList.addAll(0, list);
        notifyDataSetChanged();
    }

    /**
     * 移除一条数据
     *
     * @param position 位置
     */
    public void removeItem(int position) {
        if (headerView == null) {
            dataList.remove(position);
        } else {
            dataList.remove(position - 1);
        }
        notifyItemRemoved(position);
    }

    /**
     * 移除一条数据
     *
     * @param data 要移除的数据
     */
    public void removeItem(M data) {
        int index = dataList.indexOf(data);
        if (index < 0) {
            return;
        }
        dataList.remove(index);
        if (headerView == null) {
            notifyItemRemoved(index);
        } else {
            notifyItemRemoved(index + 1);
        }
    }

    /**
     * 替换一个数据
     *
     * @param data
     */
    public void updateItem(M data) {
        int index = dataList.indexOf(data);
        if (index < 0) {
            return;
        }
        dataList.set(index, data);
        if (headerView == null) {
            notifyItemChanged(index);
        } else {
            notifyItemChanged(index + 1);
        }
    }

    /**
     * 根据位置获取一条数据
     *
     * @param position View的位置
     * @return 数据
     */
    public M getItem(int position) {
        if (headerView != null && position == 0
                || position >= dataList.size() + getHeaderExtraViewCount()) {
            return null;
        }
        return headerView == null ? dataList.get(position) : dataList.get(position - 1);
    }

    /**
     * 根据ViewHolder获取数据
     *
     * @param holder ViewHolder
     * @return 数据
     */
    public M getItem(VH holder) {
        return getItem(holder.getAdapterPosition());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dataList.size() + getExtraViewCount();
    }

    @Override
    public final int getItemViewType(int position) {
        if (headerView != null && position == 0) {
            return VIEW_TYPE_HEADER;
        } else if (footerView != null && position == dataList.size() + getHeaderExtraViewCount()) {
            return VIEW_TYPE_FOOTER;
        } else {
            return getCustomViewType(position);
        }
    }

    /**
     * 获取自定义View的类型
     *
     * @param position 位置
     * @return View的类型
     */
    public abstract int getCustomViewType(int position);



}
