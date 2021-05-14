package com.mf._07_Synchronized;

/**
 * @author mf
 * @create 2021-05-14-15:52
 */
//不安全的买票
    //线程不安全，有负数，有相同的票号
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"a").start();
        new Thread(buyTicket,"b").start();
        new Thread(buyTicket,"c").start();

    }
}
class BuyTicket implements Runnable{
    //票
    private int ticketNums=10;
    boolean flag=true;
    @Override
    public void run() {
        while (flag){
           buy();
        }
    }
    //买票
    //synchronized同步方法 ,锁的是this
    private synchronized void buy(){
        //判断是否有票
        if(ticketNums<=0){
            flag=false;
            return;
        }
        //模拟延迟方法问题发生性
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "买到第" + ticketNums-- + "张票");
    }

}
