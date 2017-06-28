package com.jia.demo.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.jia.demo.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Describtion:自定义的万能Banner
 * Created by jia on 2017/3/24 0024.
 * 人之所以能，是相信能
 */
public class JsViewPager extends FrameLayout {

    // 上下文
    private Context mContext;
    // itemView数组
    private ImageView[] imgViews;
    // ViewPager
    private ViewPager mViewPager;
    // 指示器容器
    private LinearLayout dotsLayout;

    // 图片地址
    private String[] imgUrls;
    // 占位图片id
    private int placeholder = R.mipmap.fragment_home_first_default;

    // 指示器位置
    private int dotsLayoutGravity = Gravity.CENTER;

    //当前指示器样式
    private int dotDrawableChecked;
    private int dotDrawableUnchecked;

    // 是否显示指示器
    private boolean showDots = true;
    // 是否自动播放
    private boolean isAutoPlay = true;
    // 当前位置
    private int currentIndex = 0;
    //定时任务
    private ScheduledExecutorService scheduledExecutorService;

    // 点击事件
    private OnJsVPItemClickListener mOnJsVPClickListener;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mViewPager.setCurrentItem((currentIndex + 1) % imgUrls.length);
        }
    };


    private class SlideTask implements Runnable {

        @Override
        public void run() {
            mHandler.obtainMessage().sendToTarget();
        }
    }

    public JsViewPager(Context context) {
        this(context, null);
    }

    public JsViewPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JsViewPager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        // 资源为空，则不做处理
        if (imgUrls == null || imgUrls.length == 0) {
            return;
        }

        LayoutInflater.from(mContext).inflate(R.layout.layout_viewpager, this, true);
        mViewPager = (ViewPager) findViewById(R.id.viewPager_ad);
        dotsLayout = (LinearLayout) findViewById(R.id.ll_dot);
        dotsLayout.removeAllViews();

        imgViews = new ImageView[imgUrls.length];
        for (int i = 0; i < imgUrls.length; i++) {

            ImageView mImageView = new ImageView(mContext);
            Glide.with(mContext)
                    .load(imgUrls[i])
                    .placeholder(placeholder)
                    .crossFade()
                    .into(mImageView);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgViews[i] = mImageView;

            final int position = i;
            mImageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnJsVPClickListener.onClickListener(position);
                }
            });
        }

        if (showDots) {
            initDots();
        }

        // 去除滑动到两端时的阴影
        mViewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);

        PagerAdapter adapter = new JsViewPagerAdapter();
        mViewPager.setAdapter(adapter);
        mViewPager.setFocusable(true);
        mViewPager.setOnPageChangeListener(new JsViewPagerChangeListener());
    }

    /**
     * 初始化指示器
     */
    private void initDots() {
        // 资源为空，则不做处理
        if (imgUrls == null || imgUrls.length == 0) {
            return;
        }

        for (int i = 0; i < imgUrls.length; i++) {
            ImageView dotView = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.leftMargin = 4;
            params.rightMargin = 4;
            dotView.setBackgroundResource(dotDrawableUnchecked);
            dotsLayout.addView(dotView, params);
        }

        dotsLayout.setGravity(dotsLayoutGravity);
        dotsLayout.getChildAt(0).setBackgroundResource(dotDrawableChecked);
    }

    /**
     * 设置当前选中的指示器
     *
     * @param position
     */
    private void setCurrentDot(int position) {
        currentIndex = position;
        if (!showDots) {
            return;
        }
        for (int i = 0; i < dotsLayout.getChildCount(); i++) {
            if (i == position) {
                dotsLayout.getChildAt(position).setBackgroundResource(dotDrawableChecked);
            } else {
                dotsLayout.getChildAt(i).setBackgroundResource(dotDrawableUnchecked);
            }
        }
    }

    /**
     * 页面滑动监听
     */
    private class JsViewPagerChangeListener implements ViewPager.OnPageChangeListener {
        boolean isScrolled;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setCurrentDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state){
                case 1:// 手势滑动
                    isScrolled=false;
                    break;
                case 2:// 界面切换
                    isScrolled=true;
                    break;
                case 0:// 滑动结束

                    if (mViewPager.getCurrentItem() == mViewPager.getAdapter().getCount() - 1 && !isScrolled) {// 当前为最后一张，此时从右向左滑，则切换到第一张
                        mViewPager.setCurrentItem(0);
                    } else if (mViewPager.getCurrentItem() == 0 && !isScrolled) {// 当前为第一张，此时从左向右滑，则切换到最后一张
                        mViewPager.setCurrentItem(mViewPager.getAdapter().getCount() - 1);
                    }

                    break;
            }
        }
    }

    /**
     * 填充ViewPager的适配器
     */
    private class JsViewPagerAdapter extends PagerAdapter {

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(imgViews[position]);
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ImageView imageView = imgViews[position];
            ((ViewPager) container).addView(imageView);
            return imageView;
        }

        @Override
        public int getCount() {
            return imgUrls == null ? 0 : imgUrls.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    /**
     * 开始轮播
     * @param delay 延迟几秒后开始
     * @param period 周期
     */
    public void startPlay(long delay, long period){
        initViewPager();
        if (isAutoPlay && imgUrls.length > 1) {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(new SlideTask(), delay, period, TimeUnit.SECONDS);
        }
    }

    /**
     * 默认1秒后开始，每6秒换一次
     */
    public void startPlay(){
        startPlay(1,6);
    }

    public JsViewPager setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
        return this;
    }

    public JsViewPager setPlaceholder(int placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public JsViewPager setDotsLayoutGravity(int dotsLayoutGravity) {
        this.dotsLayoutGravity = dotsLayoutGravity;
        return this;
    }

    public JsViewPager setShowDots(boolean showDots) {
        this.showDots = showDots;
        return this;
    }

    public JsViewPager setAutoPlay(boolean autoPlay) {
        isAutoPlay = autoPlay;
        return this;
    }


    public JsViewPager setDotDrawableChecked(int dotDrawableChecked) {
        this.dotDrawableChecked = dotDrawableChecked;
        return this;
    }

    public JsViewPager setDotDrawableUnchecked(int dotDrawableUnchecked) {
        this.dotDrawableUnchecked = dotDrawableUnchecked;
        return this;
    }

    public JsViewPager setmOnJsVPClickListener(OnJsVPItemClickListener mOnJsVPClickListener) {
        this.mOnJsVPClickListener = mOnJsVPClickListener;
        return this;
    }

    public interface OnJsVPItemClickListener {
        void onClickListener(int position);
    }
}
