package com.lean.ssm.chapter2.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * ������壺CGLIB��̬���� ��Ҫ���cglib.jar��
 */
public class CGLIBProxyExample implements MethodInterceptor {
    /**
     * ����CGLIB�������
     * @param cls Class��
     * @return Class���CGLIB�������
     */
    public Object getProxy(Class cls){
        Enhancer enhancer=new Enhancer();//CGLIB enhancer��ǿ����� ��Ҫ����asm.jar�� ��Ȼ�ᱨ��java.lang.NoClassDefFoundError: org/objectweb/asm/Type
        enhancer.setSuperclass(cls);//������ǿ����
        enhancer.setCallback(this);//��������߼�����Ϊ��ǰ����Ҫ��ǰ����ʵ��MethodInterceptor����
        return enhancer.create();//���ɲ����ش������
    }

    /**
     * �����߼�����
     * @param o �������
     * @param method ����
     * @param objects ��������
     * @param methodProxy ��������
     * @return �����߼�����
     * @throws Throwable �쳣
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("������ʵ����ǰ");
        Object result=methodProxy.invokeSuper(o,objects);
        System.err.println("������ʵ�����");
        return result;
    }
}
