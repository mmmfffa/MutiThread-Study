package com.mf._06_Priority;

import javax.swing.*;

/**
 * @author mf
 * @create 2021-05-14-15:24
 */
//测试守护线程
    //上帝守护你  人生不过三万天
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        //设置上帝为守护线程
        thread.setDaemon(true);//正常的默认false是用户线程
        thread.start();

        new Thread(you).start();//用户线程启动


    }

}
//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("God guard You!");
        }
    }
}
//你
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("You live happily!"+i);
        }
        System.out.println("good Bye!");
    }
}