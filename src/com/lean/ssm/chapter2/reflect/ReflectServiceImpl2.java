package com.lean.ssm.chapter2.reflect;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * 座右铭：    无敌是多麽寂寞
 */
public class ReflectServiceImpl2 {
    private String name;
    public ReflectServiceImpl2(String name){
        this.name=name;
    }
    public void sayHello(String name){
        System.err.println("hello,"+name);
    }
}
