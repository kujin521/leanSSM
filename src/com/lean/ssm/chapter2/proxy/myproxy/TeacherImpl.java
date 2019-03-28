package com.lean.ssm.chapter2.proxy.myproxy;

import com.lean.ssm.chapter2.proxy.myproxy.People;

/**
 * Author:  kujin
 * Email:  1604323361@qq.com
 * Date:   2019/3/28
 * ������壺��ʦ�� ʵ����people work
 */
public class TeacherImpl implements People {
    @Override
    public synchronized String work() {
        new Thread(new Runnable() {//�̲߳����ã�
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("��ʦ������");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return "����";
    }
}
