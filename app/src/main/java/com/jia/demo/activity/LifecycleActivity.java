package com.jia.demo.activity;

import android.os.Bundle;

import com.jia.demo.R;
import com.jia.demo.lifecycle.LifecycleObserverDemo;

public class LifecycleActivity extends android.arch.lifecycle.LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        // 添加
        getLifecycle().addObserver(new LifecycleObserverDemo());
    }
}

/**
 * Lifecycle 是 Android Architecture Components 的一个组件，用于将系统组件（Activity、Fragment等等）
 * 的生命周期分离到 Lifecycle 类，Lifecycle 允许其他类作为观察者，观察组件生命周期的变化。
 * Lifecycle 用起来很简单，首先声明一个 LifecycleObserver 对象，用 @OnLifecycleEvent 注解声明生命周期事件回调的方法：
 */

/**
 * 最后再提一下，Lifecycle 还提供了内置了另外三个 LifecycleOnwer：
  *   LifecycleFragment
  *   LifecycleService，ServiceLifecycleDispatcher 将事件派发重新推到主线程消息队列，用于保证确保回调在 Service 生命周期回调后再调用。
  *   ProcessLifecycleOwner，用于监听整个应用的前后台切换。也是利用 ActivityLifecycleCallback 监听每个 Activity 的生命周期，如果 onStop 事件后，没有监听到任意的 onStart 事件，那么 ProcessLifecycleOwner 就会认为整个应用切换到后台，同时留下一个标志。如果监听到 onStart 事件，同时检查有标志那么就会认为应用回到前台。
 */
