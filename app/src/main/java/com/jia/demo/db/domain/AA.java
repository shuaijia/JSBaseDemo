package com.jia.demo.db.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Describtion:
 * Created by jia on 2017/4/5 0005.
 * 人之所以能，是相信能
 */
@Entity
public class AA {

    @Id
    private Long id;

    private String note;

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 306009084)
    public AA(Long id, String note) {
        this.id = id;
        this.note = note;
    }

    @Generated(hash = 1749961025)
    public AA() {
    }
}
