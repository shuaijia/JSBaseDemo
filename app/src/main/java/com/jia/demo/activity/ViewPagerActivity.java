package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.jia.demo.R;
import com.jia.demo.view.JsViewPager;

/**
 * Describtion:
 * Created by jia on 2017/3/24 0024.
 * 人之所以能，是相信能
 */
public class ViewPagerActivity extends Activity implements JsViewPager.OnJsVPItemClickListener {

    private JsViewPager vp;

    private String[] urls = {"http://upload-images.jianshu.io/upload_images/1039119-ca24721feca05e41.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
            "http://upload-images.jianshu.io/upload_images/3621024-fef1b7e198af96b6.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
            "http://upload-images.jianshu.io/upload_images/2839449-91042bb5548711d7.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
            "http://upload-images.jianshu.io/upload_images/3298160-26e84db95ee82c6c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        vp = (JsViewPager) findViewById(R.id.vp);
        vp.setPlaceholder(R.mipmap.fragment_home_first_default)
                .setDotDrawableChecked(R.drawable.shape_home_first_zhuanqu_select)
                .setDotDrawableUnchecked(R.drawable.shape_home_first_zhuanqu_normal)
                .setShowDots(true)
                .setAutoPlay(true)
                .setDotsLayoutGravity(Gravity.RIGHT)
                .setmOnJsVPClickListener(this)
                .setImgUrls(urls)
                .startPlay();

    }

    @Override
    public void onClickListener(int position) {
        Toast.makeText(ViewPagerActivity.this, position + "", Toast.LENGTH_LONG).show();
    }
}
