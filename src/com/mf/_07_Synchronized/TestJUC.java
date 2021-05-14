package com.mf._07_Synchronized;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mf
 * @create 2021-05-14-17:09
 */
//测试JUC安全类型的集合,CopyOnWriteArrayList是JAVA类下的并发包
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
