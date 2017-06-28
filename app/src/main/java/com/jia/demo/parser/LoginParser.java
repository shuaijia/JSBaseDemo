package com.jia.demo.parser;

import com.google.gson.Gson;
import com.jia.demo.base.BaseModel;
import com.jia.demo.base.BaseParser;
import com.jia.demo.bean.Login;

/**
 * Describtion:
 * Created by jia on 2017/3/9 0009.
 * 人之所以能，是相信能
 */
public class LoginParser extends BaseParser<Login> {
    @Override
    public Login parseJSON(String str) {
        Gson gson=new Gson();
        Login obj= gson.fromJson(str,Login.class);
        return obj;
    }
}
