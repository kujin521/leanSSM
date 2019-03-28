package com.lean.ssm.chapter2.proxy.myproxy;

import com.lean.ssm.chapter2.proxy.myproxy.People;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * 类的意义：老师类 实现了people work
 */
public class TeacherImpl implements People {
    @Override
    public synchronized String work() {
        new Thread(new Runnable() {//线程不管用？
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("老师教育人");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return "教育";
    }
}
