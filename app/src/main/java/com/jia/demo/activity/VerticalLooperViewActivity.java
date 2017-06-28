package com.jia.demo.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.jia.demo.R;
import com.jia.demo.base.BaseActivity;
import com.jia.demo.bean.VerticalLooper;
import com.jia.demo.view.CircularImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Description: 纵向轮播的界面
 * Created by jia on 2017/04/12
 * 人之所以能，是相信能
 */
public class VerticalLooperViewActivity extends BaseActivity {

    // 纵向跑马灯
    private ViewFlipper vf_vertical_looper;

    // 数据源
    private List<VerticalLooper> list = new ArrayList<>();

    // 直播定时器
    private Timer timer;

    //记录当前的位置
    private int mCurrPos = 0;

    @Override
    public int setLayoutId() {
        return R.layout.activity_vertical_looper_view;
    }

    @Override
    public void dealIntent(Intent intent) {


    }

    @Override
    public void initView() {
        vf_vertical_looper = (ViewFlipper) findViewById(R.id.vf_vertical_looper);
    }

    @Override
    public void initData() {
        list.add(new VerticalLooper("我是条目1", "https://img13.360buyimg.com/n4/s130x130_jfs/t4057/363/665075855/88680/37c364b6/58589017Na74fe1ae.jpg", "aa"));
        list.add(new VerticalLooper("我是条目2", "https://img13.360buyimg.com/n4/s130x130_jfs/t4057/363/665075855/88680/37c364b6/58589017Na74fe1ae.jpg", "bb"));
        list.add(new VerticalLooper("我是条目3", "https://img13.360buyimg.com/n4/s130x130_jfs/t4057/363/665075855/88680/37c364b6/58589017Na74fe1ae.jpg", "cc"));
        list.add(new VerticalLooper("我是条目4", "https://img13.360buyimg.com/n4/s130x130_jfs/t4057/363/665075855/88680/37c364b6/58589017Na74fe1ae.jpg", "dd"));
        list.add(new VerticalLooper("我是条目5", "https://img13.360buyimg.com/n4/s130x130_jfs/t4057/363/665075855/88680/37c364b6/58589017Na74fe1ae.jpg", "ee"));
        list.add(new VerticalLooper("我是条目6", "https://img13.360buyimg.com/n4/s130x130_jfs/t4057/363/665075855/88680/37c364b6/58589017Na74fe1ae.jpg", "ff"));


        setViewFlipper();

    }

    private void setViewFlipper() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setView(mCurrPos, mCurrPos + 1);
                        vf_vertical_looper.setInAnimation(VerticalLooperViewActivity.this, R.anim.in_bottomtop);
                        vf_vertical_looper.setOutAnimation(VerticalLooperViewActivity.this, R.anim.out_bottomtop);
                        vf_vertical_looper.showNext();
                    }
                });
            }
        };
        // 4秒轮播一次
        if (timer != null) {
            timer.schedule(task, 0, 4000);
        } else {
            timer = new Timer();
            timer.schedule(task, 0, 4000);
        }

    }

    private void setView(final int curr, int next) {
        View itemView = LayoutInflater.from(VerticalLooperViewActivity.this).inflate(R.layout.item_vertical_looper, null);
        CircularImage ci_vertical_looper = (CircularImage) itemView.findViewById(R.id.ci_vertical_looper);
        TextView tv_vertical_looper = (TextView) itemView.findViewById(R.id.tv_vertical_looper);

        if ((curr < next) && (next > (list.size() - 1))) {
            next = 0;
        } else if ((curr > next) && (next < 0)) {
            next = list.size() - 1;
        }

        tv_vertical_looper.setText(list.get(curr).getTitle() + "");
        if(VerticalLooperViewActivity.this!=null){
            Glide.with(VerticalLooperViewActivity.this)
                    .load(list.get(curr).getImgUrl())
                    .crossFade()
                    .into(ci_vertical_looper);
        }



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VerticalLooperViewActivity.this, list.get(curr).getWebUrl() + "", Toast.LENGTH_LONG).show();
            }
        });
        if (vf_vertical_looper.getChildCount() > 1) {
            vf_vertical_looper.removeViewAt(0);
        }

        vf_vertical_looper.addView(itemView, vf_vertical_looper.getChildCount());
        mCurrPos = next;
    }


    @Override
    public void onClick(int ViewId) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
