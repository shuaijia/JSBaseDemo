package com.jia.demo.download;

/**
 * Describtion:
 * Created by jia on 2017/7/10.
 * 人之所以能，是相信能
 */
public enum Person {

    JIA(1,"jia"),ZHANG(2,"zhang"),KANG(3,"kang");

    private int id;

    private String name;

    private Person(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
