package com.lean.ssm.chapter2.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * 座右铭：    无敌是多麽寂寞
 */
public class ReflectTest {
    public static void main(String[] args) {

    }

    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object=null;
        try {
            object= (ReflectServiceImpl) Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {//实例化异常
            e.printStackTrace();
        } catch (IllegalAccessException e) {//非法访问异常
            e.printStackTrace();
        } catch (ClassNotFoundException e) {//类无法找到异常
            e.printStackTrace();
        }
        return object;
    }
    public Object reflectMethod(){
        Object retuenobj=null;
        ReflectServiceImpl target=new ReflectServiceImpl();
        try {
            Method method=ReflectServiceImpl.class.getMethod("sayHello", String.class);
            //Method method=target.getClass().getMethod("sayHello", String.class);//同上
            retuenobj=method.invoke(target,"张三");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return retuenobj;
    }
    @Test
    public Object reflect(){
        ReflectServiceImpl object=null;
        try {
            object= (ReflectServiceImpl)
                    Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
            Method method=object.getClass().getMethod("sayHello", String.class);
            method.invoke(object,"张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return object;
    }

    public void myString(){
        System.out.println("SHUCHU");
    }

}
