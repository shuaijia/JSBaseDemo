package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.jia.demo.R;
import com.jia.demo.adapter.HuaLangAdapter;
import com.jia.demo.utils.MyGallyPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Describtion: 画廊界面
 * Created by jia on 2017/6/26.
 * 人之所以能，是相信能
 */
public class HuaLangActivity extends Activity {

    private ViewPager vp_lunbo;
    private RelativeLayout rl_hualang;
    int a;

    private List<String> list=new ArrayList<>();

    int page=2000;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==10){
                vp_lunbo.setCurrentItem(++page);
                handler.sendEmptyMessageDelayed(10,3000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hualang);
        vp_lunbo= (ViewPager) findViewById(R.id.vp_lunbo);
        rl_hualang= (RelativeLayout) findViewById(R.id.rl_hualang);

//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090193&di=fd9fb992182afdf4ad1e404736d77981&imgtype=0&src=http%3A%2F%2Fpic33.photophoto.cn%2F20141204%2F0006019060393096_b.jpg");
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090193&di=b16bfe2c722ff3bd311aa99efa6e141f&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2014%2Fxll%2F01%2F26%2F4%2Ffengguang1.jpg");
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090192&di=07b9fc85d3631391ab6a70f1930af41a&imgtype=0&src=http%3A%2F%2Fpic10.nipic.com%2F20100929%2F4308872_150108084472_2.jpg");
//        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090192&di=a14f531dfdab902c59e651e9d9a744d3&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F87%2F72%2F73t58PICjpT_1024.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090190&di=bc5c189a5aea963ffa0d13ae110ec248&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F130331%2F240460-13033106243430.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090190&di=bc5c189a5aea963ffa0d13ae110ec248&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F130331%2F240460-13033106243430.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090190&di=bc5c189a5aea963ffa0d13ae110ec248&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F130331%2F240460-13033106243430.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090190&di=bc5c189a5aea963ffa0d13ae110ec248&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F130331%2F240460-13033106243430.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090190&di=bc5c189a5aea963ffa0d13ae110ec248&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F130331%2F240460-13033106243430.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498478090190&di=bc5c189a5aea963ffa0d13ae110ec248&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F130331%2F240460-13033106243430.jpg");


        int pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp = vp_lunbo.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        vp_lunbo.setLayoutParams(lp);
        //setPageMargin表示设置图片之间的间距
        vp_lunbo.setOffscreenPageLimit(2);
        vp_lunbo.setPageMargin(-50);
        //clipChild用来定义他的子控件是否要在他应有的边界内进行绘制。 默认情况下，clipChild被设置为true。 也就是不允许进行扩展绘制。
        vp_lunbo.setClipChildren(false);
        //父容器一定要设置这个，否则看不出效果
        rl_hualang.setClipChildren(false);
        vp_lunbo.setPageTransformer(true,new MyGallyPageTransformer());
        vp_lunbo.setAdapter(new HuaLangAdapter( list,HuaLangActivity.this));
        vp_lunbo.setCurrentItem(page);

        handler.sendEmptyMessageDelayed(10,3000);

        vp_lunbo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page=position;
//                handler.sendEmptyMessageDelayed(10,3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                handler.removeMessages(10);
            }
        });
    }

}
