package com.lean.ssm.chapter2.proxy.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * 类的意义：
 */
public class WorkHandler implements InvocationHandler {
    private Object object;//真实对象
    public WorkHandler(){}
    public WorkHandler(Object object){
        this.object=object;//构造函数 给真实对象赋值
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在真实对象执行之前我们可以进行自己的操作
        long before = 0,after=0;//定义开始时间和结束时间
        System.out.println("操作开始时间"+(before=new Date().getTime()));
        Object invoke=method.invoke(object,args);
        System.out.println("操作结束时间"+(after=new Date().getTime()));
        System.out.println("时间间隔："+(after-before));
        return invoke;
    }
}
