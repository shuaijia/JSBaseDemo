package com.jia.demo.bean;

/**
 * Description: 雪花效果实体类
 * Created by jia on 2017/12/25.
 * 人之所以能，是相信能
 */
public class Snow {

    private float x;
    private float y;
    private int alfa;
    private float size;
    private float speed;
    private int srcType;

    public Snow(float x, float y, int alfa, float size, float speed, int srcType) {
        this.x = x;
        this.y = y;
        this.alfa = alfa;
        this.size = size;
        this.speed = speed;
        this.srcType = srcType;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getAlfa() {
        return alfa;
    }

    public void setAlfa(int alfa) {
        this.alfa = alfa;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getSrcType() {
        return srcType;
    }

    public void setSrcType(int srcType) {
        this.srcType = srcType;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "x=" + x +
                ", y=" + y +
                ", alfa=" + alfa +
                ", size=" + size +
                ", speed=" + speed +
                ", srcType=" + srcType +
                '}';
    }
}
