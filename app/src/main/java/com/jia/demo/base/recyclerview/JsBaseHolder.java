package com.jia.demo.base.recyclerview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Describtion: ViewHolder的封装类
 * Created by jia on 2017/3/17
 * 人之所以能，是相信能
 */
public class JsBaseHolder extends RecyclerView.ViewHolder {

    /**
     * View的缓存
     * SparseArray类似于HashMap，以键值对形式存储数据
     *     SparseArray比HashMap更省内存，在某些条件下性能更好，主要是因为它避免了
     *     对key的自动装箱（int转为Integer类型），它内部则是通过两个数组来进行数据
     *     存储的，一个存储key，另外一个存储value，为了优化性能，它内部对数据还采取
     *     了压缩的方式来表示稀疏数组的数据，从而节约内存空间
     */
    private SparseArray<View> viewArray;

    /**
     * 构造方法
     * @param itemView 布局View
     */
    public JsBaseHolder(View itemView) {
        super(itemView);
        viewArray=new SparseArray<View>();
    }

    /**
     * 构造ViewHolder
     * @param parent 父类容器
     * @param resId 布局资源文件id
     */
    public JsBaseHolder(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        viewArray = new SparseArray<>();
    }

    /**
     * 获取布局中的View
     * @param viewId view的资源id
     * @param <T>
     * @return
     */
    public <T extends View>T getView(@IdRes int viewId){
        View view=viewArray.get(viewId);
        if(view==null){
            view=itemView.findViewById(viewId);
            viewArray.put(viewId,view);
        }

        return (T) view;
    }

    /**
     * 获取Context实例
     *     这里的itemView是父类的属性，表示一个item最外层View
     * @return
     */
    public Context getContext(){
        return itemView.getContext();
    }
}
