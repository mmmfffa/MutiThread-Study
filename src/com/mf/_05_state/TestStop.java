package com.mf._05_state;

/**
 * @author mf
 * @create 2021-05-14-9:40
 */
//测试stop
    //1.建议线程正常停止
    //2.建议使用标志位
    //3.不建议使用stop和destroy(),JDK不推荐
public class TestStop implements Runnable{
    //1.设置一个标志位
    private boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run....Thread"+i++);
        }
    }
    //2.设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main->"+i);
            if(i==80) {
                testStop.stop();
                System.out.println("线程终止");
            }

        }

    }

}
