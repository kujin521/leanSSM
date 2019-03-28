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
 * 座右铭：    无敌是多麽寂寞
 */
public class ProxyTest {
    public static void main(String[] args) {

    }

    @Test
    public void testJdkProxy() {
        JdkProxyExample jdk=new JdkProxyExample();//创建动态代理和代理逻辑的实例
        //--》HelloWordImpl（）--》bind（）--》返回代理对象
        HellowWord proxy= (HellowWord) jdk.bind(new HelloWordImpl());//代理实例绑定真实对象
        //--》进入invoke（）
        proxy.sayHelloWord();
    }

    @Test
    public void testCDLIBProxy() {
        CGLIBProxyExample cpe=new CGLIBProxyExample();
        ReflectServiceImpl obj= (ReflectServiceImpl) cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello("张三");
    }

    @Test
    public void testTecherProxy(){
        People people = new TeacherImpl();
        InvocationHandler handler=new WorkHandler(people);
        //Proxy.newProxyInstance()做动态代理，只能是代理接口和实现类。
        // 不能代理抽象类和实现类。不然就会报转换异常错误。
        Object o = Proxy.newProxyInstance
                (people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        People p1= (People) o;
        System.out.println(p1.work());
    }

}
