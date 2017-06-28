package com.jia.demo.activity;

import android.content.Intent;
import android.database.SQLException;
import android.util.Log;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.base.BaseActivity;
import com.jia.demo.bean.JavaObjectExt;

/**
 * Describtion: java基础
 * Created by jia on 2017/5/8.
 * 人之所以能，是相信能
 */
public class JavaActivity extends BaseActivity {

    private TextView tv;

    @Override
    public int setLayoutId() {
        return R.layout.activity_java;
    }

    @Override
    public void dealIntent(Intent intent) {

    }

    @Override
    public void initView() {
        tv= (TextView) findViewById(R.id.tv_java);
    }

    @Override
    public void initData() {
        /**
         * 父类中定义了一个带参构造方法，然后子类继承后构造方法必须先调用父类方法带参构造方法，方法调用为super(参数,...)
         * 如果父类含有不带参构造方法，那么子类就不需要上述操作
         */
        JavaObjectExt obj=new JavaObjectExt(2);


        /**
         * 多个catch语句的时候，抛出异常会顺序来判断
         *     捕获后就不会向下执行其他捕获语句
         */
        String str = null;
        try {
            int length = str.length();
        }catch (SQLException e){
            Log.e("Tag","SQLException");
        }catch (NullPointerException e){
            Log.e("Tag","NullPointerException");
        }catch (RuntimeException e){
            Log.e("Tag","RuntimeException");
        }catch (Exception e){
            Log.e("Tag","Exception");
        }finally {
            Log.e("Tag","finally");
        }

    }

    @Override
    public void onClick(int ViewId) {

    }
}
