package com.jia.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.jia.demo.R;
import com.jia.demo.bean.VerticalLooper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Description: 纵向走马灯TextView
 * Created by jia on 2017/04/12
 * 人之所以能，是相信能
 */
public class JsVerticalLooperView extends ViewFlipper {

    // 数据源
    private List<VerticalLooper> list = new ArrayList<>();

    // 直播定时器
    private Timer timer;

    //记录当前的位置
    private int mCurrPos = 0;

    private Context mContext;

    public JsVerticalLooperView(Context context, List<VerticalLooper> list) {
        super(context);
        this.list = list;
        this.mContext = context;

        setViewFlipper();
    }

    public JsVerticalLooperView(Context context, AttributeSet attrs, List<VerticalLooper> list) {
        super(context, attrs);

        this.list = list;
        this.mContext = context;

        setViewFlipper();
    }

    private void setViewFlipper() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        setView(mCurrPos, mCurrPos + 1);
//                        setInAnimation(mContext, R.anim.in_bottomtop);
//                        setOutAnimation(mContext, R.anim.out_bottomtop);
//                        showNext();
//                    }
//                });
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
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_vertical_looper, null);
        CircularImage ci_vertical_looper = (CircularImage) itemView.findViewById(R.id.ci_vertical_looper);
        TextView tv_vertical_looper = (TextView) itemView.findViewById(R.id.tv_vertical_looper);

        if ((curr < next) && (next > (list.size() - 1))) {
            next = 0;
        } else if ((curr > next) && (next < 0)) {
            next = list.size() - 1;
        }

        tv_vertical_looper.setText(list.get(curr).getTitle() + "");
        Glide.with(mContext)
                .load(list.get(curr).getImgUrl())
                .crossFade()
                .into(ci_vertical_looper);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, list.get(curr).getWebUrl() + "", Toast.LENGTH_LONG).show();
            }
        });
        if (getChildCount() > 1) {
            removeViewAt(0);
        }

        addView(itemView, getChildCount());
        mCurrPos = next;
    }



}
