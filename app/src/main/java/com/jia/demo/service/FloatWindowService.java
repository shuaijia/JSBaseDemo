package com.jia.demo.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jia.demo.R;

/**
 * Description: 悬浮窗 服务
 * Created by jia on 2018/6/20.
 * 人之所以能，是相信能。
 */

public class FloatWindowService extends Service {

    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showFloatingWindow();
        return super.onStartCommand(intent, flags, startId);
    }

    private void showFloatingWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                // 获取WindowManager服务
                windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

                // 新建悬浮窗控件
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                final View displayView = layoutInflater.inflate(R.layout.image_display_float, null);
                displayView.setOnTouchListener(new FloatingOnTouchListener());

                ImageView imageView = (ImageView) displayView.findViewById(R.id.image_display_imageview);
                imageView.setOnTouchListener(new FloatingOnTouchListener());

                ImageView iv_close = (ImageView) displayView.findViewById(R.id.iv_close);
                iv_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        windowManager.removeView(displayView);
                    }
                });

                // 设置LayoutParam
                layoutParams = new WindowManager.LayoutParams();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
//                } else {
                layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
//                }

                layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_FULLSCREEN
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
                layoutParams.gravity = Gravity.CENTER | Gravity.TOP; // 调整悬浮窗口至左上角
                // 以屏幕左上角为原点，设置x、y初始值
                layoutParams.x = 0;
                layoutParams.y = 80;
                layoutParams.format = PixelFormat.RGBA_8888;
                layoutParams.width = 300;
                layoutParams.height = 160;

                // 将悬浮窗控件添加到WindowManager
                windowManager.addView(displayView, layoutParams);

            }
        }

    }

    private class FloatingOnTouchListener implements View.OnTouchListener {
        private int x;
        private int y;

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = (int) event.getRawX();
                    y = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int nowX = (int) event.getRawX();
                    int nowY = (int) event.getRawY();
                    int movedX = nowX - x;
                    int movedY = nowY - y;
                    x = nowX;
                    y = nowY;
                    layoutParams.x = layoutParams.x + movedX;
                    layoutParams.y = layoutParams.y + movedY;

                    // 更新悬浮窗控件布局
                    windowManager.updateViewLayout(view, layoutParams);
                    break;
                default:
                    break;
            }
            return false;
        }
    }
}
