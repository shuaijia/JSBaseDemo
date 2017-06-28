package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.jia.demo.R;
import com.jia.demo.base.BaseParser;
import com.jia.demo.bean.Login;
import com.jia.demo.config.UrlConfig;
import com.jia.demo.net.JSListener;
import com.jia.demo.net.NetWorkUtils;
import com.jia.demo.parser.LoginParser;

/**
 * Describtion:OkHttp测试的Activity
 * Created by jia on 2017/3/30 0030.
 * 人之所以能，是相信能
 */
public class OkHttpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_okhttp);

        //=================网络请求测试============================
        NetWorkUtils.post(UrlConfig.loginUrl,
                NetWorkUtils.createParamsMap("loginId","1","passwd","a"),
                new LoginParser(),
                new JSListener() {
                    @Override
                    public void onSuccess(Object model) {
                        Toast.makeText(OkHttpActivity.this, "成功" + ((Login) model).getData(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFaile(String error) {
                        Toast.makeText(OkHttpActivity.this, "失败" + error, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
