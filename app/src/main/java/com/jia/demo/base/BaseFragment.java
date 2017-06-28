package com.jia.demo.base;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Describtion:Fragment的封装基类
 * Created by jia on 2017/3/17
 * 人之所以能，是相信能
 */
public abstract class BaseFragment extends DialogFragment implements IBaseFragment {

    /**
     * fragment的contentView
     */
    private View contentView;

    /**
     * 所属Activity
     */
    private Activity activity;

    /**
     * contentView是否已经被创建
     */
    private boolean isViewCreated;


    /**
     * 通过id查找控件
     *
     * @param resId
     * @param <V>
     * @return
     */
    final public <V extends View> V findViewById(@IdRes int resId) {
        return (V) contentView.findViewById(resId);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    final public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 防止重复调用onCreate方法，造成在initData方法中adapter重复初始化问题
        if (!isViewCreated) {
            isViewCreated = true;
            initData();
        }
    }

    @Nullable
    @Override
    final public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentView == null) {
            // 强制竖屏显示
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            int layoutResId = getCreateViewId();
            if (layoutResId > 0) {
                contentView = inflater.inflate(layoutResId, container, false);

                // 解决点击事件穿透的问题
                contentView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return true;
                    }
                });
            }
        }
        return contentView;
    }

    @Override
    final public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isViewCreated) {
            findView(view, savedInstanceState);
            initView(view, savedInstanceState);
            initDialog();
            initListener();
            isViewCreated = false;
        }
    }

    @CallSuper
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Override
    public void dismiss() {
        // 捕获异常不至于造成崩溃
        try {
            super.dismiss();
        } catch (Exception e) {
        }
    }

    @Override
    public void dismissAllowingStateLoss() {
        // 捕获异常不至于造成崩溃
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception e) {
        }
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
    }

    // 第一个注解表示任何子类都必须重写此方法
    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 解决ViewPager中的问题
        if (null != contentView) {
            ((ViewGroup) contentView.getParent()).removeView(contentView);
        }
    }

    @CallSuper
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
