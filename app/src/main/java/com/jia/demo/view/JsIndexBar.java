package com.jia.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.jia.demo.utils.DisplayUtil;

/**
 * Describtion:快速索引栏
 * Created by jia on 2017/4/6
 * 人之所以能，是相信能
 */
public class JsIndexBar extends View {

    /**
     * 默认索引字母颜色
     */
    private static final int LETTER_COLOR = 0xFF2E8BE6;

    /**
     * 索引字母数组
     */
    private String[] indexs = {};

    /**
     * 控件宽高
     */
    private int mWidth;
    private int mHeight;

    /**
     * 单元格高度
     */
    private int mCellHeight;

    /**
     * 距顶距离
     */
    private float mMarginTop;

    /**
     * 画笔
     */
    private Paint mPaint;

    /**
     * 展示字母的view
     */
    private TextView mTextView;

    /**
     * 切换索引监听
     */
    private OnIndexChangedListener onIndexChangedListener;

    public JsIndexBar(Context context) {
        super(context);
        initPaint();
    }

    public JsIndexBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(LETTER_COLOR);
        // getContext()直接返回当前View的上下文
        mPaint.setTextSize(DisplayUtil.dp2px(getContext(), 12));
        // 去掉锯齿，让字体边缘变得平滑
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (indexs.length <= 0) {
            return;
        }

        for (int i = 0; i < indexs.length; i++) {
            String text = indexs[i];
            float x = (mWidth - getTextWidth(text)) / 2;
            float y = mMarginTop + mCellHeight * i + mCellHeight / 2 + getTextHeight(text) / 2;
            canvas.drawText(text, x, y, mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();
        // 26个字母加#
        mCellHeight = mHeight / 27;
        mMarginTop = (mHeight - mCellHeight * indexs.length) / 2;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_HOVER_MOVE:
                // 按下字母的下标
                int letterIndex = (int) ((event.getY() - mMarginTop) / mCellHeight);
                // 判断是否越界
                if (letterIndex >= 0 && letterIndex < indexs.length) {
                    // 显示按下的字母
                    if (mTextView != null) {
                        mTextView.setVisibility(View.VISIBLE);
                        mTextView.setText(indexs[letterIndex]);
                    }
                    //通过回调方法通知列表定位
                    if (onIndexChangedListener != null) {
                        onIndexChangedListener.onIndexChanged(indexs[letterIndex]);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                // 隐藏TextView
                if(mTextView!=null){
                    mTextView.setVisibility(View.GONE);
                }
                break;
        }

        return true;
    }

    /**
     * 设置索引
     * @param indexs
     */
    public void setIndexs(String[] indexs) {
        this.indexs = indexs;
        mMarginTop = (mHeight - mCellHeight * indexs.length) / 2;
        invalidate();
    }

    /**
     * 获取文字宽度
     *
     * @param text
     * @return
     */
    private float getTextWidth(String text) {
        Rect bounds = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), bounds);
        return bounds.width();
    }

    /**
     * 获取文字高度
     *
     * @param text
     * @return
     */
    private float getTextHeight(String text) {
        Rect bounds = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), bounds);
        return bounds.height();
    }


    /**
     * 设置监听
     *
     * @param onIndexChangedListener
     */
    public void setOnIndexChangedListener(OnIndexChangedListener onIndexChangedListener) {
        this.onIndexChangedListener = onIndexChangedListener;
    }

    public interface OnIndexChangedListener {
        void onIndexChanged(String index);
    }


    public void setSelectedIndexTextView(TextView mTextView) {
        this.mTextView = mTextView;
    }
}
