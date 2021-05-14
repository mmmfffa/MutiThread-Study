package com.mf._01_thread;

/**
 * @author mf
 * @create 2021-05-13-9:17
 */
//创建线程方式一：继承thread类，重写run方法，调用start方法开启线程
public class TestThread01 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程-thread-"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程对象
        TestThread01 testThread01 = new TestThread01();
        //调用start()方法开启线程
        //testThread01.run();
        testThread01.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("学习多线程-main-"+i);
        }
    }
}
