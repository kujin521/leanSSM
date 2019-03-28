package com.lean.ssm.chapter2.intercept;

import java.lang.reflect.Method;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * ������壺�����������ӿ�
 */
public interface Interceptor {
    /**
     * ��ʵ����ǰ����
     * @param proxy �������
     * @param target ��ʵ����
     * @param method ����
     * @param args ��������
     * @return true:��ʵ����ķ��� false:����around����
     */
    boolean before(Object proxy, Object target, Method method,Object[] args);
    /**
     * ��ʵ����
     * @param proxy �������
     * @param target ��ʵ����
     * @param method ����
     * @param args ��������
     * @return true:��ʵ����ķ��� false:����around����
     */
    void around(Object proxy,Object target,Method method,Object[] args);
    /**
     * around֮��ִ��
     * @param proxy �������
     * @param target ��ʵ����
     * @param method ����
     * @param args ��������
     */
    void after(Object proxy,Object target,Method method,Object[] args);
}
