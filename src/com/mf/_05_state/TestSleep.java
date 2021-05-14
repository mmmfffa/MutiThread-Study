package com.mf._05_state;

/**
 * @author mf
 * @create 2021-05-14-10:15
 */
//模拟网络延时:放大问题发生性
public class TestSleep implements Runnable{
    private int ticketNums=10;
    @Override
    public void run() {
        while (true){
            if (ticketNums<=0) break;
            //模拟网络延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--拿到了票--》"+ticketNums--);
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket,"冯冯").start();
        new Thread(ticket,"哈哈").start();
        new Thread(ticket,"呵呵").start();
    }
}
