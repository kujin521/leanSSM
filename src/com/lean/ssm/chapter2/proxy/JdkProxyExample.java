package com.lean.ssm.chapter2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * 座右铭：    无敌是多麽寂寞
 */
//动态代理绑定和代理逻辑实现类

/**
 * 每一个动态代理类的调用处理程序都必须实现InvocationHandler接口
 * 当我们通过动态代理对象调用一个方法时候，
 * 这个方法的调用就会被转发到实现InvocationHandler接口类的invoke方法来调用
 */
public class JdkProxyExample implements InvocationHandler {
    private Object target=null;//真实对象

    /**
     * 1.建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target){
        this.target=target;
        //Proxy.newProxyInstance(类加载器,动态代理需要的接口,代理类);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    /**
     * 代理方法逻辑
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 当前方法参数
     * @return 代理结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object object=method.invoke(target,args);//相当于调用sayHelloWorld
        System.out.println("在调度真实对象之后的服务");
        return object;
    }
}
