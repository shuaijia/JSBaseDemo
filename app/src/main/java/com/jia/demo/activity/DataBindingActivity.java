package com.jia.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.base.BaseActivity;
import com.jia.demo.bean.DataBindingBean;
import com.jia.demo.databinding.ActivityDatabindingBinding;

/**
 * Description: 数据绑定测试
 * Created by jia on 2017/04/10
 * 人之所以能，是相信能
 */
public class DataBindingActivity extends Activity {

    // 数据绑定
    private TextView tv_databinding;
    // 事件绑定
    private Button bt_databinding;

    // 绑定布局的名字，去掉下划线，最后加Binding
    private ActivityDatabindingBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);

        tv_databinding = (TextView) findViewById(R.id.tv_databinding);
        bt_databinding = (Button) findViewById(R.id.bt_databinding);

        DataBindingBean bean=new DataBindingBean("aa","bb");

        viewDataBinding.setData(bean);

    }




}
