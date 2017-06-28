package com.jia.demo.bean;

/**
 * Describtion: 索引Recycler的实体类
 * Created by jia on 2017/4/6 0006.
 * 人之所以能，是相信能
 */
public class IndexEntry {

    private String name;
    private String firstWord;
    private boolean isIndex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }

    public IndexEntry(String name, String firstWord) {
        this.name = name;
        this.firstWord = firstWord;
    }

    public IndexEntry(){}
}
