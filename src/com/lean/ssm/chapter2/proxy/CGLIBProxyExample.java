package com.lean.ssm.chapter2.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * 类的意义：CGLIB动态代理 需要添加cglib.jar包
 */
public class CGLIBProxyExample implements MethodInterceptor {
    /**
     * 生成CGLIB代理对象
     * @param cls Class类
     * @return Class类的CGLIB代理对象
     */
    public Object getProxy(Class cls){
        Enhancer enhancer=new Enhancer();//CGLIB enhancer增强类对象 需要导入asm.jar包 不然会报错java.lang.NoClassDefFoundError: org/objectweb/asm/Type
        enhancer.setSuperclass(cls);//设置增强类型
        enhancer.setCallback(this);//定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
        return enhancer.create();//生成并返回代理对象
    }

    /**
     * 代理逻辑方法
     * @param o 代理对象
     * @param method 方法
     * @param objects 方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前");
        Object result=methodProxy.invokeSuper(o,objects);
        System.err.println("调用真实对象后");
        return result;
    }
}
