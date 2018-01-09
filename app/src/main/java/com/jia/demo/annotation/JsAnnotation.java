package com.jia.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 自定义注解
 * Created by jia on 2018/1/9.
 * 人之所以能，是相信能
 *
 * 1.@interface关键字定义注解，
 * 2.注解可以被其它注解修饰,最重要的就是元注解。
 * 3.注解和接口类似，内部可以定义常量和方法。
 * 4.注解定义的方法有一些限制：方法不能有参数；返回值只能是基本类型、字符串、Class、枚举、注解、及以上类型的数组；可以包含默认值。
 */
@Target(ElementType.TYPE) //注解作用于类型（类，接口，注解，枚举）
@Retention(RetentionPolicy.RUNTIME) //运行时保留，运行中可以处理
@Inherited // 注解将被用于该类的子类
@Documented // 生成javadoc文件
public @interface JsAnnotation {

    String DEFAULT_VALUE = "JS";

    /**
     * 颜色枚举
     *
     * @author peida
     */
    enum Color {
        BULE, RED, GREEN
    }

    /**
     * 创建此value方法，则使用注解时可直接传参，如 @JsAnnotation("msg")
     *
     * @return
     */
    String value() default DEFAULT_VALUE;

    /**
     * 此方法返回为枚举类型，使用注解时，如 @JsAnnotation(color=Color.BLUE)
     *
     * @return
     */
    Color color() default Color.BULE;

    int num() default -1;
}
