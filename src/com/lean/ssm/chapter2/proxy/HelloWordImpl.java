package com.lean.ssm.chapter2.proxy;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * ��������    �޵��Ƕ����į
 */
//�ӿ�ʵ��
public class HelloWordImpl implements HellowWord {
    @Override
    public void sayHelloWord() {
        System.out.println("Hello,Word");
    }
}
