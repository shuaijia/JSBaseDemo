package com.jia.demo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.playlog.internal.LogEvent;
import com.jia.demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description: 设置单次鱼丸奖励 框
 * Created by jia on 2018/5/14.
 * 人之所以能，是相信能。
 */

public class FishBallOncePopupWindow extends PopupWindow implements View.OnClickListener {

    private RadioGroup mRadioGroup;
    private ImageView mCloseIv;
    private TextView mSureTv;

    private List<RadioButton> rbs = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    private OnSureClickListener listener;

    private String selectVaule = "";

    private Context context;

    public FishBallOncePopupWindow(final Context context) {
        super(context);
        this.context = context;
        View view = View.inflate(context, R.layout.im_popup_fish_ball_pool_once, null);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_yw_pool_once_content);
        mCloseIv = (ImageView) view.findViewById(R.id.iv_yw_pool_once_close);
        mSureTv = (TextView) view.findViewById(R.id.tv_yw_pool_once_sure);

        mCloseIv.setOnClickListener(this);
        mSureTv.setOnClickListener(this);

        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void addButton(final String... texts) {
        if (texts.length != 0) {
            for (int i = 0; i < texts.length; i++) {

                RadioButton rb = new RadioButton(context);
                Bitmap a = null;
                rb.setButtonDrawable(new BitmapDrawable(a));
                rb.setBackgroundResource(R.drawable.im_selector_ye_pool_bt);
                rb.setText(texts[i] + "鱼丸");
                rb.setGravity(Gravity.CENTER);
                rb.setTextColor(context.getResources().getColorStateList(R.color.im_selector_yw_pool_text));

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                lp.setMargins(10, 0, 10, 6);
                rb.setLayoutParams(lp);
                mRadioGroup.addView(rb);

                final int finalI = i;
                rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) selectVaule = texts[finalI];
                    }
                });

                if (i == 0) rb.setChecked(true);

                rbs.add(rb);
                values.add(texts[i]);
            }
        }

    }

    @Override
    public void dismiss() {
        super.dismiss();
        mRadioGroup.clearCheck();
        mRadioGroup.removeAllViews();
    }

    /**
     * 通过索引选择，并返回所选内容
     *
     * @param index
     * @return
     */
    public String selectedByIndex(int index) {
        if (index >= rbs.size()) return "";

        for (int i = 0; i < rbs.size(); i++) {
            if (i == index) {
                rbs.get(i).setChecked(true);
            } else {
                rbs.get(i).setChecked(false);
            }
        }

        return selectVaule;
    }

    @Override
    public void onClick(View v) {
        if (v == mCloseIv) {
            dismiss();
        } else if (v == mSureTv) {
            if (listener != null)
                listener.onClick(selectVaule);
            dismiss();
        }
    }

    public void setListener(OnSureClickListener listener) {
        this.listener = listener;
    }

    public interface OnSureClickListener {
        void onClick(String value);
    }
}
