package com.mf._06_Priority;

/**
 * @author mf
 * @create 2021-05-14-15:08
 */
//测试线程优先级
public class TestPriority{
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        //先设置完有优先级在启动
        t1.start();;

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();



    }

}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}