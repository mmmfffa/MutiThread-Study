package com.mf._09_Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mf
 * @create 2021-05-14-17:49
 */
//测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(myLock,"a").start();
        new Thread(myLock,"b").start();
        new Thread(myLock,"c").start();

    }
}
class MyLock implements Runnable{
    int ticketNums=10;
    //定义可重入锁
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
       while (true){

           try {
               lock.lock();//加锁
               if(ticketNums<=0) {
                   System.out.println("票已卖完");
                   break;
               }else {
                   try {
                       Thread.sleep(200);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+"正在买第 " + ticketNums-- + " 张票");
               }

           } finally {
               //解锁
               lock.unlock();
           }


       }
    }
}