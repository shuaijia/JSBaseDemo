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

    private static final String TAG = "JavaActivity";

    private TextView tv;

    private boolean exit = false;

    private Thread t;

    @Override
    public int setLayoutId() {
        return R.layout.activity_java;
    }

    @Override
    public void dealIntent(Intent intent) {

    }

    @Override
    public void initView() {
        tv = (TextView) findViewById(R.id.tv_java);
        tv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        /**
         * 父类中定义了一个带参构造方法，然后子类继承后构造方法必须先调用父类方法带参构造方法，方法调用为super(参数,...)
         * 如果父类含有不带参构造方法，那么子类就不需要上述操作
         */
        JavaObjectExt obj = new JavaObjectExt(2);


        /**
         * 多个catch语句的时候，抛出异常会顺序来判断
         *     捕获后就不会向下执行其他捕获语句
         */
        String str = null;
        try {
            int length = str.length();
        } catch (SQLException e) {
            Log.e("Tag", "SQLException");
        } catch (NullPointerException e) {
            Log.e("Tag", "NullPointerException");
        } catch (RuntimeException e) {
            Log.e("Tag", "RuntimeException");
        } catch (Exception e) {
            Log.e("Tag", "Exception");
        } finally {
            Log.e("Tag", "finally");
        }

        /**
         * 正在运行中的线程不会被垃圾回收器回收，即使
         * 将线程对象置null，手动调用System.gc()也不会回收
         *
         * 但当线程执行结束后，垃圾回收器便可以回收
         */
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!exit) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e(TAG, "thread is running ");
                }
            }
        });

        t.start();


        t = null;
        System.gc();
    }

    @Override
    public void onClick(int ViewId) {
        if (ViewId == R.id.tv_java) {
            exit=true;

            t=null;
            System.gc();
        }
    }
}
