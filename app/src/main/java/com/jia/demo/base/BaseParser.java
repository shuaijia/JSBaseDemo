package com.jia.demo.base;


/**
 * Describtion: 解析类父类
 * Created by jia on 2017/3/9 0009.
 * 人之所以能，是相信能
 */
public abstract class BaseParser<T> {

    public abstract T parseJSON(String str);

}