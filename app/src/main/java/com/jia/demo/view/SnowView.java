package com.jia.demo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.jia.demo.R;
import com.jia.demo.bean.Snow;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 圣诞节 下雪花 自定义view
 * Created by jia on 2017/12/25.
 * 人之所以能，是相信能
 */
public class SnowView extends SurfaceView implements SurfaceHolder.Callback {

    // 雪花集合
    private List<Snow> snows;

    // 画笔
    private Paint mPaint;

    private SurfaceHolder surfaceHolder;

    // 当前雪花
    private Snow curSnow;

    // 一屏最多雪花书
    private int maxCount = 85;

    private DrawThread mDrawThread;

    private Bitmap bgBitmap;

    public SnowView(Context context, AttributeSet attrs) {
        super(context, attrs);

        surfaceHolder = this.getHolder();
        surfaceHolder.addCallback(this);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        bgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.snow_bg);

        init();

    }

    private void init() {

        DisplayMetrics dm = getResources().getDisplayMetrics();
        snows = new ArrayList<>();

        float x, y, size, speed;
        int alfa, srcType;

        for (int i = 0; i < maxCount; i++) {
            x = (float) Math.floor(Math.random() * dm.widthPixels);//初始X坐标
            y = (float) Math.floor(Math.random() * dm.heightPixels);//初始Y坐标

            size = (float) ((Math.random() * 15f) + 20f);//初始半径
            speed = (float) ((Math.random() * 6) + 5);
            alfa = (int) Math.floor(100 * Math.random() + 155);
            srcType = (int) (Math.random() + 0.5);

            snows.add(new Snow(x, y, alfa, size, speed, srcType));
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (null == mDrawThread) {
            mDrawThread = new DrawThread();
            mDrawThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (null != mDrawThread) {
            mDrawThread.stopThread();
        }
    }

    /**
     * 绘制进程
     */
    class DrawThread extends Thread {

        public boolean isRunning = false;
        private Canvas canvas;

        public DrawThread() {
            isRunning = true;
        }

        @Override
        public void run() {
            super.run();

            while (isRunning) {

                synchronized (surfaceHolder) {
                    // Start editing the pixels in the surface.  The returned Canvas can be used to draw into the surface's bitmap.
                    canvas = surfaceHolder.lockCanvas();

                    drawSprite(canvas);

                    for (int i = 0; i < maxCount; i++) {

                        curSnow = snows.get(i);

                        float size = curSnow.getSize();
                        float speed = curSnow.getSpeed();
                        int alfa = curSnow.getAlfa();
                        float x = curSnow.getX();
                        float y = curSnow.getY() + speed;
                        int type = curSnow.getSrcType();

                        if (y >= canvas.getHeight() || x >= canvas.getWidth()) {
                            y = 0;
                            x = (float) Math.floor(Math.random() * canvas.getWidth());//初始X坐标
                        }

                        mPaint.setAlpha(alfa);

                        Bitmap snowBitmap;
                        if (type == 1) {
                            snowBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.snow1);
                        } else {
                            snowBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.snow2);
                        }

                        RectF rect = new RectF(x, y, x + size, y + size);

                        canvas.drawBitmap(snowBitmap, null, rect, mPaint);

                        snows.set(i, new Snow(x, y, alfa, size, speed, type));
                    }

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }

            }

        }

        public void stopThread() {
            isRunning = false;
            boolean workIsNotFinish = true;
            while (workIsNotFinish) {
                try {
                    this.join();// 保证run方法执行完毕
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                workIsNotFinish = false;
            }
        }
    }

    private void drawSprite(Canvas canvas) {
        //清屏操作
        canvas.drawBitmap(bgBitmap, null, new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), null);

    }
}
