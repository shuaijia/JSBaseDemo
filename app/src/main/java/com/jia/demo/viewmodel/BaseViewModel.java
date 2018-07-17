package com.jia.demo.viewmodel;

/**
 * Description:
 * Created by jia on 2018/7/17.
 * 人之所以能，是相信能。
 */

public interface BaseViewModel<T> {

    T loadData();

    void clearData();

    void changeData();
}
