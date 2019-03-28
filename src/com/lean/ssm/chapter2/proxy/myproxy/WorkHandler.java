package com.lean.ssm.chapter2.proxy.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * ������壺
 */
public class WorkHandler implements InvocationHandler {
    private Object object;//��ʵ����
    public WorkHandler(){}
    public WorkHandler(Object object){
        this.object=object;//���캯�� ����ʵ����ֵ
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //����ʵ����ִ��֮ǰ���ǿ��Խ����Լ��Ĳ���
        long before = 0,after=0;//���忪ʼʱ��ͽ���ʱ��
        System.out.println("������ʼʱ��"+(before=new Date().getTime()));
        Object invoke=method.invoke(object,args);
        System.out.println("��������ʱ��"+(after=new Date().getTime()));
        System.out.println("ʱ������"+(after-before));
        return invoke;
    }
}
