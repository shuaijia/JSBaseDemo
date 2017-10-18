package com.jia.demo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.jia.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 雷达表
 * Created by jia on 2017/10/18.
 * 人之所以能，是相信能
 */
public class JsRadarChart extends View {

    private static final String TAG = "JsRadarChart";

    /**
     * 雷达边数 默认6
     */
    private int mPieceNumber = 6;

    /**
     * 外接圆半径
     */
    private int mRadius = 50;

    /**
     * 线条宽度 默认10
     */
    private int mLineWidth = 8;

    /**
     * 线条颜色 默认灰色
     */
    private int mLineColor = 0xffd0d6dc;

    /**
     * 半径分为4段
     */
    private int mLineSegments = 4;

    /**
     * 字体颜色和字体大小
     */
    private int mTextColor = 0xff647d91;
    private int mTextSize = 10;

    /**
     * 覆盖物颜色
     */
    private int mCoverColor = 0x55ced657;

    /**
     * 中心位置
     */
    private int mPositionX = 0;
    private int mPositionY = 0;

    /**
     * 多边形 边的角度
     */
    private double mAverageAngle = 0;

    /**
     * 三只画笔
     */
    private Paint mRadarPaint;
    private TextPaint mTextPaint;
    private Paint mCoverPaint;

    private Path mCoverPath;

    /**
     * 所有边对应的点的集合，每一个item是每条边上所有的结点的集合
     */
    List<RadarPoints> mRadarPointses = new ArrayList<>();
    /**
     * 实体类集合
     */
    List<RadarEntry> mRadarEntries = new ArrayList<>();
    /**
     * 覆盖物的顶点的集合
     */
    List<PointF> mCoverPoints = new ArrayList<>();
    /**
     * 文字对应点的集合
     */
    List<PointF> mTextPoints = new ArrayList<>();

    public JsRadarChart(Context context) {
        this(context, null);
    }

    public JsRadarChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JsRadarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 获取属性类型集
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.RadarChart);

        mLineWidth = (int) attributes.getDimension(R.styleable.RadarChart_radarLineWidth, 5);
        mLineColor = attributes.getColor(R.styleable.RadarChart_radarLineColor, 0xffd0d6dc);
        mLineSegments = attributes.getInteger(R.styleable.RadarChart_radarLineSegments, 4);
        mTextColor = attributes.getColor(R.styleable.RadarChart_radarTextColor, 0xff647d91);
        mTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                attributes.getInteger(R.styleable.RadarChart_radarTextSize, 10), getResources().getDisplayMetrics());
        mCoverColor = attributes.getColor(R.styleable.RadarChart_radarCoverColor, 0x55ced6dc);

        init();
    }

    private void init() {

        // 蜘蛛网 画笔初始化
        mRadarPaint = new Paint();
        mRadarPaint.setColor(mLineColor);
        mRadarPaint.setStrokeWidth(mLineWidth);
        mRadarPaint.setAntiAlias(true);
        mRadarPaint.setStyle(Paint.Style.STROKE);

        // 文字绘制 画笔初始化
        mTextPaint = new TextPaint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.STROKE);

        // 覆盖物 画笔初始化
        mCoverPaint = new Paint();
        mCoverPaint.setColor(mCoverColor);
        mCoverPaint.setAntiAlias(true);
        mCoverPaint.setStyle(Paint.Style.FILL);

        mCoverPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: ");

        /**
         * 绘制中心点
         */
        canvas.drawPoint(mPositionX, mPositionY, mRadarPaint);

        /**
         * 绘制蜘蛛网
         */
        for (int i = 0; i < mLineSegments; i++) {
            for (int j = 0; j < mPieceNumber - 1; j++) {
                canvas.drawLine(mRadarPointses.get(j).getPointFs().get(i).x, mRadarPointses.get(
                        j).getPointFs().get(i).y,
                        mRadarPointses.get(j + 1).getPointFs().get(i).x, mRadarPointses.get(
                                j + 1).getPointFs().get(i).y, mRadarPaint);
            }

            canvas.drawLine(mRadarPointses.get(mPieceNumber - 1).getPointFs().get(i).x,
                    mRadarPointses.get(mPieceNumber - 1).getPointFs().get(i).y,
                    mRadarPointses.get(0).getPointFs().get(i).x, mRadarPointses.get(
                            0).getPointFs().get(i).y, mRadarPaint);
        }

        /**
         * 绘制轴线
         */
        for (int k = 0; k < mPieceNumber; k++) {
            canvas.drawLine(mRadarPointses.get(k).getPointFs().get(0).x,
                    mRadarPointses.get(k).getPointFs().get(0).y,
                    mRadarPointses.get(k).getPointFs().get(mLineSegments - 1).x, mRadarPointses.get(
                            k).getPointFs().get(mLineSegments - 1).y, mRadarPaint);

        }

        /**
         * 绘制数据
         */
        if (mCoverPoints != null && mCoverPoints.size() == mPieceNumber) {
            mCoverPath.reset();
            mCoverPath.moveTo(mCoverPoints.get(0).x, mCoverPoints.get(0).y);
            for (int i = 1; i < mPieceNumber; i++) {
                mCoverPath.lineTo(mCoverPoints.get(i).x, mCoverPoints.get(i).y);
            }
            mCoverPath.close();
            canvas.drawPath(mCoverPath, mCoverPaint);
        } else {
            throw new NullPointerException("请先设置数据集");
        }


        /**
         * 绘制文字,使用StaticLayout进行换行文字的绘制
         */
        for (int i = 0; i < mPieceNumber; i++) {
            canvas.save();
            String str = mRadarEntries.get(i).title + "\n" +
                    Math.floor(mRadarEntries.get(i).level * 10) / 10;
            StaticLayout layout = new StaticLayout(str, mTextPaint, 300,
                    Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
            canvas.translate(mTextPoints.get(i).x, mTextPoints.get(i).y);
            layout.draw(canvas);
            canvas.restore();
        }
    }

    /**
     * View一创建，就会执行此方法，w和h就是最新的控件宽高度
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: " + w + " : " + h);

        // 计算中心点位置
        mPositionX = w / 2;
        mPositionY = h / 2;

        // 计算角度
        mAverageAngle = 360.0 / mPieceNumber;

        // 计算出文字所占大小
        int textSizeMax = 0;
        for (RadarEntry entry : mRadarEntries) {
            Rect textRect = new Rect();
            mTextPaint.getTextBounds(entry.title, 0, entry.title.length(), textRect);
            textSizeMax = Math.max(textRect.width(), textSizeMax);
        }

        // 出去文字区域，算出最合适半径
        mRadius = Math.min(mPositionX - textSizeMax, mPositionY);

        if (mRadarEntries == null || mRadarEntries.size() == 0) {
            throw new NullPointerException("请先设置数据集");
        }


        /**
         * 计算每一条轴线上的所有结点
         *      x轴正方向为第一条轴线，顺时针旋转
         */
        for (int i = 0; i < mPieceNumber; i++) {
            List<PointF> pointFs = new ArrayList<>();
            for (int j = 0; j < mLineSegments; j++) {
                PointF point = new PointF();
                double percent = j * 1.0 / (mLineSegments - 1);
                point.set(getPloygonX(mAverageAngle * i, percent),
                        getPloygonY(mAverageAngle * i, percent));
                pointFs.add(point);
            }
            RadarPoints radarPoints = new RadarPoints(i, pointFs);
            mRadarPointses.add(radarPoints);
        }

        /**
         * 根据数据集计算覆盖多变形的点
         */
        for (int m = 0; m < mPieceNumber; m++) {
            PointF pointF = new PointF();
            double percent = mRadarEntries.get(m).level / 100.0;
            pointF.set(getPloygonX(mAverageAngle * m, percent),
                    getPloygonY(mAverageAngle * m, percent));
            mCoverPoints.add(pointF);
        }

        /**
         * 设置文字显示位置
         */
        for (int m = 0; m < mPieceNumber; m++) {
            PointF pointF = new PointF();
            String title = mRadarEntries.get(m).title;
            Rect textBound = new Rect();
            mTextPaint.getTextBounds(title, 0, title.length(),
                    textBound);
            // 每条边最后一个点的位置，设置文字
            float boundx = mRadarPointses.get(m).getPointFs().get(mLineSegments - 1).x;
            float boundy = mRadarPointses.get(m).getPointFs().get(mLineSegments - 1).y;

            if (boundx > mRadius && boundy <= mRadius) {
                pointF.set(getPloygonX(mAverageAngle * m, 1),
                        getPloygonY(mAverageAngle * m, 1) - textBound.height() * 2);
            } else if (boundx <= mRadius && boundy <= mRadius) {
                pointF.set(getPloygonX(mAverageAngle * m, 1) - textBound.width(),
                        getPloygonY(mAverageAngle * m, 1) - textBound.height() * 2);
            } else if (boundx <= mRadius && boundy > mRadius) {
                pointF.set(getPloygonX(mAverageAngle * m, 1) - textBound.width(),
                        getPloygonY(mAverageAngle * m, 1));
            } else {
                pointF.set(getPloygonX(mAverageAngle * m, 1),
                        getPloygonY(mAverageAngle * m, 1));
            }
            mTextPoints.add(pointF);
        }

    }

    /**
     * 设置数据集，数据集的index决定位置，顺时针方向，起始角度为0度
     */
    public void setRadatEntries(List<RadarEntry> entries) {
        this.mRadarEntries = entries;
        mPieceNumber = entries.size();
        postInvalidate();
    }

    public float getPloygonX(double angle, double percent) {
        return Float.parseFloat(
                String.valueOf(
                        mPositionX + Math.cos(angle / 360.0 * 2 * Math.PI) * mRadius * percent));
    }

    public float getPloygonY(double angle, double percent) {
        return Float.parseFloat(String.valueOf(
                mPositionY + Math.sin(angle / 360.0 * 2 * Math.PI) * mRadius * percent));
    }

    /**
     * 雷达图数据载体
     */
    public static class RadarEntry {
        private String title;
        private double level;

        public RadarEntry(String title, double level) {
            this.title = title;
            this.level = level;
        }
    }

    /**
     * 每一条线上的所有点集合
     */
    class RadarPoints {
        int lineIndex;
        List<PointF> mPointFs;

        public RadarPoints(int lineIndex, List<PointF> pointFs) {
            this.lineIndex = lineIndex;
            mPointFs = pointFs;
        }

        public int getLineIndex() {
            return lineIndex;
        }

        public void setLineIndex(int lineIndex) {
            this.lineIndex = lineIndex;
        }

        public List<PointF> getPointFs() {
            return mPointFs;
        }

        public void setPointFs(List<PointF> pointFs) {
            mPointFs = pointFs;
        }
    }
}
