package com.lean.ssm.chapter2.proxy;

import com.lean.ssm.chapter2.proxy.myproxy.People;
import com.lean.ssm.chapter2.proxy.myproxy.TeacherImpl;
import com.lean.ssm.chapter2.proxy.myproxy.WorkHandler;
import com.lean.ssm.chapter2.reflect.ReflectServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * ��������    �޵��Ƕ����į
 */
public class ProxyTest {
    public static void main(String[] args) {

    }

    @Test
    public void testJdkProxy() {
        JdkProxyExample jdk=new JdkProxyExample();//������̬����ʹ����߼���ʵ��
        //--��HelloWordImpl����--��bind����--�����ش������
        HellowWord proxy= (HellowWord) jdk.bind(new HelloWordImpl());//����ʵ������ʵ����
        //--������invoke����
        proxy.sayHelloWord();
    }

    @Test
    public void testCDLIBProxy() {
        CGLIBProxyExample cpe=new CGLIBProxyExample();
        ReflectServiceImpl obj= (ReflectServiceImpl) cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello("����");
    }

    @Test
    public void testTecherProxy(){
        People people = new TeacherImpl();
        InvocationHandler handler=new WorkHandler(people);
        //Proxy.newProxyInstance()����̬����ֻ���Ǵ���ӿں�ʵ���ࡣ
        // ���ܴ���������ʵ���ࡣ��Ȼ�ͻᱨת���쳣����
        Object o = Proxy.newProxyInstance
                (people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        People p1= (People) o;
        System.out.println(p1.work());
    }

}
