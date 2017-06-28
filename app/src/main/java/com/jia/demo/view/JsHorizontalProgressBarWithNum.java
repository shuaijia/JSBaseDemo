package com.jia.demo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;

import com.jia.demo.R;

/**
 * Describtion:横向带数字的进度条
 * Created by jia on 2017/4/28.
 * 人之所以能，是相信能
 */
public class JsHorizontalProgressBarWithNum extends View {

    /**
     * 进度值最大值
     */
    private int mMaxProgress = 100;

    /**
     * 当前进度值，不能超过进度值最大值
     */
    private int mCurrentProgress = 0;

    /**
     * 当前进度值文本之前的进度条颜色
     */
    private int mReachedBarColor;

    /**
     * 当前进度值文本之后的进度条颜色
     */
    private int mUnreachedBarColor;

    /**
     * 当前进度值文本的颜色
     */
    private int mTextColor;

    /**
     * 当前进度值文本的字体大小
     */
    private float mTextSize;

    /**
     * 当前进度值文本之前的进度条的高度
     */
    private float mReachedBarHeight;

    /**
     * 当前进度值文本之后的进度条的高度
     */
    private float mUnreachedBarHeight;

    /**
     * 当前进度值的百分比后缀
     */
    private String mSuffix = "%";

    /**
     * 当前进度值的百分比前缀
     */
    private String mPrefix = "";

    //当前进度值文本的默认颜色
    private int default_text_color = Color.rgb(66, 145, 241);
    //当前进度值文本的字体大小
    private float default_text_size;

    //当前进度值之前的默认进度条颜色
    private int default_reached_color = Color.rgb(66, 145, 241);
    //当前进度值之后的默认进度条颜色
    private int default_unreached_color = Color.rgb(204, 204, 204);

    //当前进度值之前文本的默认间距
    private float default_progress_text_offset;

    //当前进度值文本之前的进度条的默认高度
    private float default_reached_bar_height;
    //当前进度值文本之后的进度条的默认高度
    private float default_unreached_bar_height;

    /**
     * For save and restore instance of progressbar.
     */
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_REACHED_BAR_HEIGHT = "reached_bar_height";
    private static final String INSTANCE_REACHED_BAR_COLOR = "reached_bar_color";
    private static final String INSTANCE_UNREACHED_BAR_HEIGHT = "unreached_bar_height";
    private static final String INSTANCE_UNREACHED_BAR_COLOR = "unreached_bar_color";
    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_PREFIX = "prefix";
    private static final String INSTANCE_TEXT_VISIBILITY = "text_visibility";
    //默认显示当前进度值文本   0为显示，1为不显示
    private static final int PROGRESS_TEXT_VISIBLE = 0;

    /**
     * 要绘制的当前进度值的文本的宽度
     */
    private float mDrawTextWidth;

    /**
     * 要绘制的当前进度值的文本的起始位置
     */
    private float mDrawTextStart;

    /**
     * 要绘制的当前进度值的文本的结束位置
     */
    private float mDrawTextEnd;

    /**
     * 要绘制的当前进度值的文本
     */
    private String mCurrentDrawText;

    /**
     * 绘制当前进度值文本之前的进度条的画笔
     */
    private Paint mReachedBarPaint;
    /**
     * 绘制当前进度值文本之后的进度条的画笔
     */
    private Paint mUnreachedBarPaint;
    /**
     * 绘制当前进度值文本的的画笔
     */
    private Paint mTextPaint;

    /**
     * 当前进度值文本之后的进度条（长方形）
     */
    private RectF mUnreachedRectF = new RectF(0, 0, 0, 0);
    /**
     * 当前进度值之前文本的进度条（长方形）
     */
    private RectF mReachedRectF = new RectF(0, 0, 0, 0);

    /**
     * 当前进度值之前文本的间距
     */
    private float mOffset;

    /**
     * 是否绘制当前进度值之后的进度条
     */
    private boolean mDrawUnreachedBar = true;
    /**
     * 是否绘制当前进度值之前的进度条
     */
    private boolean mDrawReachedBar = true;
    /**
     * 是否绘制当前进度值文本
     */
    private boolean mIfDrawText = true;

    /**
     * 进度监听
     */
    private OnProgressBarListener mListener;

    public enum ProgressTextVisibility {
        Visible, Invisible
    }

    public JsHorizontalProgressBarWithNum(Context context) {
        this(context,null);
    }

    public JsHorizontalProgressBarWithNum(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.numberProgressBarStyle);
    }

    public JsHorizontalProgressBarWithNum(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 设置默认宽高大小
        default_reached_bar_height = dp2px(1.5f);
        default_unreached_bar_height = dp2px(1.0f);
        default_text_size = sp2px(10);
        default_progress_text_offset = dp2px(3.0f);

        // 获取自定义属性
        TypedArray attributes=context.getTheme().obtainStyledAttributes(attrs, R.styleable.NumberProgressBar, defStyleAttr, 0);
        mReachedBarColor = attributes.getColor(R.styleable.NumberProgressBar_progress_reached_color, default_reached_color);
        mUnreachedBarColor = attributes.getColor(R.styleable.NumberProgressBar_progress_unreached_color, default_unreached_color);
        mTextColor = attributes.getColor(R.styleable.NumberProgressBar_progress_text_color, default_text_color);
        mTextSize = attributes.getDimension(R.styleable.NumberProgressBar_progress_text_size, default_text_size);

        mReachedBarHeight = attributes.getDimension(R.styleable.NumberProgressBar_progress_reached_bar_height, default_reached_bar_height);
        mUnreachedBarHeight = attributes.getDimension(R.styleable.NumberProgressBar_progress_unreached_bar_height, default_unreached_bar_height);
        mOffset = attributes.getDimension(R.styleable.NumberProgressBar_progress_text_offset, default_progress_text_offset);
        // 是否显示文本
        int textVisible = attributes.getInt(R.styleable.NumberProgressBar_progress_text_visibility, PROGRESS_TEXT_VISIBLE);

        if (textVisible != PROGRESS_TEXT_VISIBLE) {
            mIfDrawText = false;
        }

        setProgress(attributes.getInt(R.styleable.NumberProgressBar_progress_current, 0));
        setMax(attributes.getInt(R.styleable.NumberProgressBar_progress_max, 100));
        //回收 TypedArray,用于后续调用时可复用之。回收到TypedArrayPool池中，以备后用
        attributes.recycle();
        initializePainters();
    }

    /**
     * 初始化画笔
     */
    private void initializePainters() {
        mReachedBarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mReachedBarPaint.setColor(mReachedBarColor);

        mUnreachedBarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mUnreachedBarPaint.setColor(mUnreachedBarColor);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
    }

    @Override
    protected int getSuggestedMinimumWidth() {
        return (int) mTextSize;
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) mTextSize, Math.max((int) mReachedBarHeight, (int) mUnreachedBarHeight));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        /**
         * MeasureSpec参数的值为int型，分为高32位和低16位，
         * 高32位保存的是specMode，低16位表示specSize，
         *
         * specMode分三种：
         1、MeasureSpec.UNSPECIFIED,父视图不对子视图施加任何限制，子视图可以得到任意想要的大小；
         2、MeasureSpec.EXACTLY，父视图希望子视图的大小是specSize中指定的大小；
         3、MeasureSpec.AT_MOST，子视图的大小最多是specSize中的大小。
         */
        setMeasuredDimension(measure(widthMeasureSpec, true), measure(heightMeasureSpec, false));
    }

    private int measure(int measureSpec, boolean isWidth) {
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        // 获取内边距
        int padding = isWidth ? getPaddingLeft() + getPaddingRight() : getPaddingTop() + getPaddingBottom();

        /**
         父决定子的确切大小，子被限定在给定的边界里，忽略本身想要的大小。
         (当设置width或height为match_parent时，模式为EXACTLY，因为子view会占据剩余容器的空间，所以它大小是确定的)
         */
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {

            result = isWidth ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight();
            result += padding;
            /**
             *子最大可以达到的指定大小
             * (当设置为wrap_content时，模式为AT_MOST, 表示子view的大小最多是多少，这样子view会根据这个上限来设置自己的尺寸)
             */
            if (mode == MeasureSpec.AT_MOST) {
                if (isWidth) {
                    result = Math.max(result, size);
                } else {
                    result = Math.min(result, size);
                }
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //如果要绘制当前进度值文本
        if (mIfDrawText) {
            calculateDrawRectF();
        }else {
            calculateDrawRectFWithoutProgressText();
        }

        //如果要绘制当前进度值之前的进度条
        if (mDrawReachedBar) {
            canvas.drawRect(mReachedRectF, mReachedBarPaint);
        }

        //如果要绘制当前进度值之后的进度条
        if (mDrawUnreachedBar) {
            canvas.drawRect(mUnreachedRectF, mUnreachedBarPaint);
        }

        //绘制当前进度值文本
        if (mIfDrawText)
            canvas.drawText(mCurrentDrawText, mDrawTextStart, mDrawTextEnd, mTextPaint);
    }

    /**
     * 计算不要绘制当前进度值文本时 图形的各个属性
     */
    private void calculateDrawRectFWithoutProgressText() {
        //当前进度值不画

        //当前进度值之前的进度条（长方形）的属性
        mReachedRectF.left = getPaddingLeft();
        mReachedRectF.top = getHeight() / 2.0f - mReachedBarHeight / 2.0f;
        mReachedRectF.right =
                (getWidth() - getPaddingLeft() - getPaddingRight()) / (getMax() * 1.0f) * getProgress()
                        + getPaddingLeft();
        mReachedRectF.bottom = getHeight() / 2.0f + mReachedBarHeight / 2.0f;

        //当前进度值之后的进度条（长方形）的属性
        mUnreachedRectF.left = mReachedRectF.right;
        mUnreachedRectF.right = getWidth() - getPaddingRight();
        mUnreachedRectF.top = getHeight() / 2.0f + -mUnreachedBarHeight / 2.0f;
        mUnreachedRectF.bottom = getHeight() / 2.0f + mUnreachedBarHeight / 2.0f;
    }

    /**
     * 计算要绘制当前进度值文本时 图形的各个属性
     */
    private void calculateDrawRectF() {
        //要绘制的当前进度值的文本
        mCurrentDrawText = String.format("%d", getProgress() * 100 / getMax());
        mCurrentDrawText = mPrefix + mCurrentDrawText + mSuffix;
        //要绘制的当前进度值的文本的宽度
        mDrawTextWidth = mTextPaint.measureText(mCurrentDrawText);
        //如果当前进度值为0，则不绘制当前进度值之前的进度条
        if (getProgress() == 0) {
            mDrawReachedBar = false;
            mDrawTextStart = getPaddingLeft();
        }
        //否则绘制当前进度值文本之前的进度条
        else {
            mDrawReachedBar = true;
            //当前进度值文本之前的进度条（长方形）的属性
            mReachedRectF.left = getPaddingLeft();
            mReachedRectF.top = getHeight() / 2.0f - mReachedBarHeight / 2.0f;
            mReachedRectF.right= (getWidth() - getPaddingLeft() - getPaddingRight()) / (getMax() * 1.0f) * getProgress()
                    - mOffset + getPaddingLeft();
            mReachedRectF.bottom = getHeight() / 2.0f + mReachedBarHeight / 2.0f;
            //当前进度值的文本的起始位置
            mDrawTextStart = (mReachedRectF.right + mOffset);
        }
        //当前进度值的文本的结束位置
        mDrawTextEnd = (int) ((getHeight() / 2.0f) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2.0f));
        //如果画不下当前进度值的文本了，就重新计算下当前进度值的文本的起始位置和当前进度值之前的进度条（长方形）的右边
        if ((mDrawTextStart + mDrawTextWidth) >= getWidth() - getPaddingRight()) {
            mDrawTextStart = getWidth() - getPaddingRight() - mDrawTextWidth;
            mReachedRectF.right = mDrawTextStart - mOffset;
        }

        //当前进度值文本之后的进度条的起始位置
        float unreachedBarStart = mDrawTextStart + mDrawTextWidth + mOffset;
        //如果画不下进度值文本之后的进度条了，就不画进度值之后的进度条
        if (unreachedBarStart >= getWidth() - getPaddingRight()) {
            mDrawUnreachedBar = false;
        } else {
            mDrawUnreachedBar = true;
            //当前进度值文本之后的进度条（长方形）的属性
            mUnreachedRectF.left = unreachedBarStart;
            mUnreachedRectF.right = getWidth() - getPaddingRight();
            mUnreachedRectF.top = getHeight() / 2.0f + -mUnreachedBarHeight / 2.0f;
            mUnreachedRectF.bottom = getHeight() / 2.0f + mUnreachedBarHeight / 2.0f;
        }
    }

    //============================以下开始为get/set方法===============================

    /**
     * 获取进度条的当前进度值
     */
    public int getProgress() {
        return mCurrentProgress;
    }

    /**
     * 设置当前进度值
     *
     * @param progress 当前进度值
     */
    public void setProgress(int progress) {
        if (progress <= getMax() && progress >= 0) {
            this.mCurrentProgress = progress;
            invalidate();
        }
    }

    /**
     * 获取进度条的最大值
     */
    public int getMax() {
        return mMaxProgress;
    }

    public void setMax(int mMaxProgress) {
        this.mMaxProgress = mMaxProgress;
    }

    public int getmReachedBarColor() {
        return mReachedBarColor;
    }

    public void setmReachedBarColor(int mReachedBarColor) {
        this.mReachedBarColor = mReachedBarColor;
    }

    public int getmUnreachedBarColor() {
        return mUnreachedBarColor;
    }

    public void setmUnreachedBarColor(int mUnreachedBarColor) {
        this.mUnreachedBarColor = mUnreachedBarColor;
    }

    public int getmTextColor() {
        return mTextColor;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public float getmTextSize() {
        return mTextSize;
    }

    public void setmTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
    }

    public float getmReachedBarHeight() {
        return mReachedBarHeight;
    }

    public void setmReachedBarHeight(float mReachedBarHeight) {
        this.mReachedBarHeight = mReachedBarHeight;
    }

    public float getmUnreachedBarHeight() {
        return mUnreachedBarHeight;
    }

    public void setmUnreachedBarHeight(float mUnreachedBarHeight) {
        this.mUnreachedBarHeight = mUnreachedBarHeight;
    }

    public String getmSuffix() {
        return mSuffix;
    }

    public void setmSuffix(String mSuffix) {
        this.mSuffix = mSuffix;
    }

    public String getmPrefix() {
        return mPrefix;
    }

    public void setmPrefix(String mPrefix) {
        this.mPrefix = mPrefix;
    }


    public float getmDrawTextWidth() {
        return mDrawTextWidth;
    }

    public void setmDrawTextWidth(float mDrawTextWidth) {
        this.mDrawTextWidth = mDrawTextWidth;
    }

    public float getmDrawTextStart() {
        return mDrawTextStart;
    }

    public void setmDrawTextStart(float mDrawTextStart) {
        this.mDrawTextStart = mDrawTextStart;
    }

    public float getmDrawTextEnd() {
        return mDrawTextEnd;
    }

    public void setmDrawTextEnd(float mDrawTextEnd) {
        this.mDrawTextEnd = mDrawTextEnd;
    }

    public String getmCurrentDrawText() {
        return mCurrentDrawText;
    }

    public void setmCurrentDrawText(String mCurrentDrawText) {
        this.mCurrentDrawText = mCurrentDrawText;
    }

    public Paint getmReachedBarPaint() {
        return mReachedBarPaint;
    }

    public void setmReachedBarPaint(Paint mReachedBarPaint) {
        this.mReachedBarPaint = mReachedBarPaint;
    }

    public Paint getmUnreachedBarPaint() {
        return mUnreachedBarPaint;
    }

    public void setmUnreachedBarPaint(Paint mUnreachedBarPaint) {
        this.mUnreachedBarPaint = mUnreachedBarPaint;
    }

    public Paint getmTextPaint() {
        return mTextPaint;
    }

    public void setmTextPaint(Paint mTextPaint) {
        this.mTextPaint = mTextPaint;
    }

    public RectF getmUnreachedRectF() {
        return mUnreachedRectF;
    }

    public void setmUnreachedRectF(RectF mUnreachedRectF) {
        this.mUnreachedRectF = mUnreachedRectF;
    }

    public RectF getmReachedRectF() {
        return mReachedRectF;
    }

    public void setmReachedRectF(RectF mReachedRectF) {
        this.mReachedRectF = mReachedRectF;
    }

    public float getmOffset() {
        return mOffset;
    }

    public void setmOffset(float mOffset) {
        this.mOffset = mOffset;
    }

    public boolean ismDrawUnreachedBar() {
        return mDrawUnreachedBar;
    }

    public void setmDrawUnreachedBar(boolean mDrawUnreachedBar) {
        this.mDrawUnreachedBar = mDrawUnreachedBar;
    }

    public boolean ismDrawReachedBar() {
        return mDrawReachedBar;
    }

    public void setmDrawReachedBar(boolean mDrawReachedBar) {
        this.mDrawReachedBar = mDrawReachedBar;
    }

    public boolean ismIfDrawText() {
        return mIfDrawText;
    }

    public void setmIfDrawText(boolean mIfDrawText) {
        this.mIfDrawText = mIfDrawText;
    }

    public OnProgressBarListener getmListener() {
        return mListener;
    }

    public void setmListener(OnProgressBarListener mListener) {
        this.mListener = mListener;
    }

    /**
     * 进度监听
     */
    public interface OnProgressBarListener {
        void onProgressChange(int current, int total);
    }

    //============================以下为工具方法==================================
    /**
     * dp转px
     */
    public float dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }
    /**
     * sp转px
     */
    public float sp2px(float sp) {
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }
}
