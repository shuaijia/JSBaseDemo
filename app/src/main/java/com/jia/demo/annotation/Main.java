package com.jia.demo.annotation;


/**
 * Description:
 * Created by jia on 2018/1/9.
 * 人之所以能，是相信能
 */
public class Main {

    public static void main(String[] args) {
        AnnotationTest test = new AnnotationTest();
        Class tClass = test.getClass();
        JsAnnotation jsAnnotation = (JsAnnotation) tClass.getAnnotation(JsAnnotation.class);

        System.out.println(jsAnnotation.value());
        System.out.println(jsAnnotation.color());
        System.out.println(jsAnnotation.num());
    }
}
