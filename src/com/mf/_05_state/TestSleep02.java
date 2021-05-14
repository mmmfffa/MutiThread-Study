package com.mf._05_state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mf
 * @create 2021-05-14-10:30
 */
//获取当前时间
public class TestSleep02 implements Runnable{

    public void testDown(){
        int num=10;
        while (true){
            try {
                Thread.sleep(1_000);
                System.out.println( num--);
                if(num<=0) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
