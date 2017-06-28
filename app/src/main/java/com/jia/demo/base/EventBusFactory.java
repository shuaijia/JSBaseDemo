package com.jia.demo.base;

import android.util.SparseArray;

import org.greenrobot.eventbus.EventBus;

/**
 * Describtion:事件总线枚举工厂类
 * Created by jia on 2017/3/31 0031.
 * 人之所以能，是相信能
 */
public enum EventBusFactory {

    CREATE(0),
    START(1);

    private int mType;

    private static SparseArray<EventBus> mBusSparseArray = new SparseArray<>(2);

    static {
        mBusSparseArray.put(CREATE.mType, EventBus.builder().build());
        mBusSparseArray.put(START.mType, EventBus.getDefault());
    }

    EventBusFactory(int mType){
        this.mType=mType;
    }

    /**
     * 获取EventBus实例
     * @return
     */
    public EventBus getBus(){
        return mBusSparseArray.get(mType);
    }
}
