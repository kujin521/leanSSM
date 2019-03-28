package com.lean.ssm.chapter2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * ��������    �޵��Ƕ����į
 */
//��̬����󶨺ʹ����߼�ʵ����

/**
 * ÿһ����̬������ĵ��ô�����򶼱���ʵ��InvocationHandler�ӿ�
 * ������ͨ����̬����������һ������ʱ��
 * ��������ĵ��þͻᱻת����ʵ��InvocationHandler�ӿ����invoke����������
 */
public class JdkProxyExample implements InvocationHandler {
    private Object target=null;//��ʵ����

    /**
     * 1.��������������ʵ����Ĵ����ϵ�������ش������
     * @param target ��ʵ����
     * @return �������
     */
    public Object bind(Object target){
        this.target=target;
        //Proxy.newProxyInstance(�������,��̬������Ҫ�Ľӿ�,������);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    /**
     * �������߼�
     * @param proxy �������
     * @param method ��ǰ���ȷ���
     * @param args ��ǰ��������
     * @return ������
     * @throws Throwable �쳣
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("��������߼�����");
        System.out.println("�ڵ�����ʵ����֮ǰ�ķ���");
        Object object=method.invoke(target,args);//�൱�ڵ���sayHelloWorld
        System.out.println("�ڵ�����ʵ����֮��ķ���");
        return object;
    }
}
