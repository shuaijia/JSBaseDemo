package com.jia.demo.bean;

import android.content.Context;
import android.widget.Toast;

/**
 * Description:事件绑定实体类
 * Created by jia on 2017/04/10
 * 人之所以能，是相信能
 */
public class EventBindingBean {

    public void onClick(Context context) {
        Toast.makeText(context, "点击事件", Toast.LENGTH_LONG).show();
    }
}
