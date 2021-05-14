package com.mf._01_thread;

/**
 * @author mf
 * @create 2021-05-13-20:54
 */
//创建线程方式2：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestThread03 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程-thread-"+i);
        }
    }

    public static void main(String[] args) {

        //创建runnable接口的实现类对象
        TestThread03 testThread03 = new TestThread03();
        //创建线程对象，通过线程对象开启我们的线程，代理
        new Thread(testThread03,"01").start();
        new Thread(testThread03,"02").start();
        new Thread(testThread03,"03").start();

        for (int i = 0; i < 200; i++) {
            System.out.println("学习多线程-main-"+i);
        }
    }
}
