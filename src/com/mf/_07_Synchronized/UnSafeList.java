package com.mf._07_Synchronized;

import java.util.ArrayList;

/**
 * @author mf
 * @create 2021-05-14-16:31
 */
//线程不安全的集合

public class UnSafeList {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            //采用lambda写线程体
           new Thread(()->{
               synchronized (strings){
                   strings.add(Thread.currentThread().getName());
               }
           }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(strings.get(0));
        System.out.println(strings.size());

    }
}
