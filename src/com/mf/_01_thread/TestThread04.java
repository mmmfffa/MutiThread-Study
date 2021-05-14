package com.mf._01_thread;

/**
 * @author mf
 * @create 2021-05-13-21:10
 */
//多个线程同时操作同一个对象
    //买火车票的例子
    //多个线程操作同一个资源的情况下线程不安全，数据混乱
public class TestThread04 implements Runnable{

    private int tickNums=10;

    @Override
    public void run() {
       while (true){
           if(tickNums<=0) break;
           try {//模拟购票延时
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+"==》拿到了第 "+tickNums+" 张票");
           tickNums--;
       }
    }

    public static void main(String[] args) {
        TestThread04 tick = new TestThread04();
        new Thread(tick,"冯冯").start();
        new Thread(tick,"艺艺").start();
        new Thread(tick,"见见").start();

    }
}
