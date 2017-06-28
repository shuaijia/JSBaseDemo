package com.jia.demo;

import android.test.AndroidTestCase;

import com.jia.demo.base.BaseModel;


/**
 * Description: 测试例子
 *        类名必须使用Test结尾，并且要继承AndroidTestCase，而单方法必须使用test开头
 *        注：***测试方法能正确走完代码即是测试通过
 * Created by jia on 2017/04/10
 * 人之所以能，是相信能
 */
public class MyDemoTest extends AndroidTestCase {

    public void testcompare(){

        BaseModel model=new BaseModel();
        model.setNote("aaaaa");

    }

}
