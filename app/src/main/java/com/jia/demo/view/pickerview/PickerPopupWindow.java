package com.jia.demo.view.pickerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.view.pickerview.adapter.AbstractWheelTextAdapter1;

import java.util.ArrayList;

/**
 * Description: 滚动选择器
 * Created by jia on 2018/5/14.
 * 人之所以能，是相信能。
 */

public class PickerPopupWindow extends PopupWindow implements View.OnClickListener {

    private WheelView wvRule;
    private WheelView wvDay;
    private View lyChangeAddressChild;
    private TextView btnSure;
    private TextView btnCancel;

    private Context context;

    private ArrayList<String> arrRules = new ArrayList<String>();
    private ArrayList<String> arrDays = new ArrayList<String>();
    private TimeTextAdapter ruleAdapter;
    private TimeTextAdapter dayAdapter;

    private String strProvince = "不续存";
    private String strCity = "1";
    private OnAddressCListener onAddressCListener;

    private int maxsize = 14;
    private int minsize = 12;

    public PickerPopupWindow(final Context context) {
        super(context);
        this.context = context;
        View view = View.inflate(context, R.layout.dialog_picker, null);

        wvRule = (WheelView) view.findViewById(R.id.wv_address_province);
        wvDay = (WheelView) view.findViewById(R.id.wv_address_city);
        lyChangeAddressChild = view.findViewById(R.id.ly_myinfo_changeaddress_child);
        btnSure = (TextView) view.findViewById(R.id.btn_myinfo_sure);
        btnCancel = (TextView) view.findViewById(R.id.btn_myinfo_cancel);


        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        lyChangeAddressChild.setOnClickListener(this);
        btnSure.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        initRules();
        ruleAdapter = new TimeTextAdapter(context, arrRules, 0, maxsize, minsize);
        wvRule.setVisibleItems(5);
        wvRule.setViewAdapter(ruleAdapter);
        wvRule.setCurrentItem(getRuleItem(strProvince));

        initDays(0);
        dayAdapter = new TimeTextAdapter(context, arrDays, 0, maxsize, minsize);
        wvDay.setVisibleItems(5);
        wvDay.setViewAdapter(dayAdapter);
        wvDay.setCurrentItem(getDayItem(strCity));

        wvRule.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // TODO Auto-generated method stub
                String currentText = (String) ruleAdapter.getItemText(wheel.getCurrentItem());
                strProvince = currentText;
                setTextviewSize(currentText, ruleAdapter);

                initDays(newValue);
                dayAdapter = new TimeTextAdapter(context, arrDays, 0, maxsize, minsize);
                wvDay.setVisibleItems(5);
                wvDay.setViewAdapter(dayAdapter);
                wvDay.setCurrentItem(0);
                setTextviewSize("0", dayAdapter);
            }
        });

        wvRule.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) ruleAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, ruleAdapter);
            }
        });

        wvDay.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // TODO Auto-generated method stub
                String currentText = (String) dayAdapter.getItemText(wheel.getCurrentItem());
                strCity = currentText;
                setTextviewSize(currentText, dayAdapter);
            }
        });

        wvDay.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) dayAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, dayAdapter);
            }
        });
    }


    private class TimeTextAdapter extends AbstractWheelTextAdapter1 {
        ArrayList<String> list;

        protected TimeTextAdapter(Context context, ArrayList<String> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxsize, minsize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index) + "";
        }
    }

    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText, TimeTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(14);
            } else {
                textvew.setTextSize(12);
            }
        }
    }

    public void setAddresskListener(OnAddressCListener onAddressCListener) {
        this.onAddressCListener = onAddressCListener;
    }

    @Override
    public void onClick(View v) {

        if (v == btnSure) {
            if (onAddressCListener != null) {
                onAddressCListener.onClick(strProvince, strCity, "");
            }
        } else if (v == btnCancel) {

        } else if (v == lyChangeAddressChild) {
            return;
        }
        dismiss();
    }

    /**
     * 回调接口
     *
     * @author Administrator
     */
    public interface OnAddressCListener {
        void onClick(String province, String city, String area);
    }

    /**
     * 初始化省会
     */
    public void initRules() {
        arrRules.add("不续存");
        arrRules.add("每月");
    }

    /**
     * 根据省会，生成该省会的所有城市
     */
    public void initDays(int flag) {
        arrDays.clear();
        if (flag == 0) {
            arrDays.add("不续存");
        } else {
            for (int i = 1; i < 29; i++) {
                arrDays.add(i + "日");
            }
        }

    }

    /**
     * 设置起始值
     */
    public void setCurrentData(String rule, String day) {
        if (rule != null && rule.length() > 0) {
            this.strProvince = rule;
            wvRule.setCurrentItem(getRuleItem(strProvince));
        }
        if (day != null && day.length() > 0) {
            this.strCity = day;
            wvDay.setCurrentItem(getRuleItem(strCity));
        }
    }

    /**
     * 返回续存规则 索引
     *
     * @return
     */
    public int getRuleItem(String rule) {
        int size = arrRules.size();
        int ruleIndex = 0;
        boolean noRule = true;
        for (int i = 0; i < size; i++) {
            if (rule.equals(arrRules.get(i))) {
                noRule = false;
                return ruleIndex;
            } else {
                ruleIndex++;
            }
        }
        if (noRule) {
            strProvince = "不续存";
            return 18;
        }
        return ruleIndex;
    }

    /**
     * 得到日期索引
     *
     * @return
     */
    public int getDayItem(String day) {
        int size = arrDays.size();
        int dayIndex = 0;
        boolean noDay = true;
        for (int i = 0; i < size; i++) {
            System.out.println(arrDays.get(i));
            if (day.equals(arrDays.get(i))) {
                noDay = false;
                return dayIndex;
            } else {
                dayIndex++;
            }
        }
        if (noDay) {
            strCity = "不续存";
            return 0;
        }
        return dayIndex;
    }
}
