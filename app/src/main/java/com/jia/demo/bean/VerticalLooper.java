package com.jia.demo.bean;

/**
 * Description:
 * Created by jia on 2017/04/12
 * 人之所以能，是相信能
 */
public class VerticalLooper {

    private String title;

    private String imgUrl;

    private String webUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public VerticalLooper(String title, String imgUrl, String webUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.webUrl = webUrl;
    }
}
