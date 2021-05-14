package com.mf._05_state;

/**
 * @author mf
 * @create 2021-05-14-11:02
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("VIP进程"+i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        //主线程
        for (int i = 0; i < 1000; i++) {
            if(i==200){
                try {
                    thread.join();//插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main"+i);
        }
    }
}
