package com.jia.demo.music;

/**
 * Description: 歌词  每行信息 实体类
 * Created by jia on 2017/10/31.
 * 人之所以能，是相信能
 */
public class LineInfo {

    private String content;

    private long startTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "LineInfo{" +
                "content='" + content + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
