package com.lean.ssm.chapter2.intercept;

import java.lang.reflect.Method;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * 类的意义：定义拦截器接口
 */
public interface Interceptor {
    /**
     * 真实对象前调用
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 方法参数
     * @return true:真实对象的方法 false:调用around方法
     */
    boolean before(Object proxy, Object target, Method method,Object[] args);
    /**
     * 真实方法
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 方法参数
     * @return true:真实对象的方法 false:调用around方法
     */
    void around(Object proxy,Object target,Method method,Object[] args);
    /**
     * around之后执行
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 方法参数
     */
    void after(Object proxy,Object target,Method method,Object[] args);
}
