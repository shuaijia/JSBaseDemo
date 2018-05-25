package com.jia.demo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jia.demo.R;

/**
 * Description: 虚线 自定义view
 * Created by jia on 2018/5/18.
 * 人之所以能，是相信能。
 */

public class JsDashLineView extends View {

    private Paint mPaint;

    private float mDashGap;
    private float mDashWidth;
    private float mDashHeight;
    private int mDashColor;

    private int mGapNum;
    private float length;

    private float viewWidth;

    public JsDashLineView(Context context) {
        super(context, null);
    }

    public JsDashLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public JsDashLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.JsDashLineView);
        mDashGap = typedArray.getDimension(R.styleable.JsDashLineView_dash_gap, 0);
        mDashWidth = typedArray.getDimension(R.styleable.JsDashLineView_dash_width, 10);
        mDashHeight = typedArray.getDimension(R.styleable.JsDashLineView_dash_height, 5);
        mDashColor = typedArray.getColor(R.styleable.JsDashLineView_dash_color, Color.parseColor("#999999"));

        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewWidth = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaint.setColor(mDashColor);
//        mPaint.setStrokeWidth(mDashHeight);
//        mPaint.setStyle(Paint.Style.STROKE);
//
//        length = mDashGap + mDashWidth;
//        mGapNum = (int) (viewWidth / length);
//
//        for (int i = 0; i < mGapNum; i++) {
//            canvas.drawLine(i * length, 0, i * length + mDashWidth, mDashHeight, mPaint);
//        }


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mDashHeight);//画笔的宽度，其实就是虚线的高度
        mPaint.setColor(mDashColor);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        float length = mDashGap + mDashWidth;
        int num = (int) Math.floor(width / length);
        for (int i = 0; i < num; i++) {
            canvas.drawLine(i * length, 0, i * length + mDashWidth, height, mPaint);
        }
    }

    public float getDashGap() {
        return mDashGap;
    }

    public void setDashGap(float mDashGap) {
        this.mDashGap = mDashGap;
    }

    public float getDashWidth() {
        return mDashWidth;
    }

    public void setDashWidth(float mDashWidth) {
        this.mDashWidth = mDashWidth;
    }

    public float getDashHeight() {
        return mDashHeight;
    }

    public void setDashHeight(float mDashHeight) {
        this.mDashHeight = mDashHeight;
    }

    public int getDashColor() {
        return mDashColor;
    }

    public void setDashColor(int mDashColor) {
        this.mDashColor = mDashColor;
    }
}
