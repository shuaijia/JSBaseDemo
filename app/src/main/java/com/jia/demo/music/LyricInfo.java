package com.jia.demo.music;

import java.util.List;

/**
 * Description: 歌词信息  实体类
 * Created by jia on 2017/10/31.
 * 人之所以能，是相信能
 */
public class LyricInfo {

    // 偏移量
    private long offset;
    // 名字
    private String title;
    // 作者
    private String artist;
    // 专辑
    private String album;
    // 制作
    private String by;

    // 歌词
    private List<LineInfo> lines;


    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public List<LineInfo> getLines() {
        return lines;
    }

    public void setLines(List<LineInfo> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "LyricInfo{" +
                "offset=" + offset +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", by='" + by + '\'' +
                ", lines=" + lines +
                '}';
    }
}
