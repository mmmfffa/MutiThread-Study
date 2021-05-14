package com.mf._10_CustomerProducer;

/**
 * @author mf
 * @create 2021-05-14-18:48
 */
//测试生产者消费者问题2：通过标志位解决，信号灯法
public class TestPC2 {
    public static void main(String[] args) {
        Programme programme = new Programme();
        new Actor(programme).start();
        new Audience(programme).start();
    }
}
//演员-生产者
class Actor extends Thread{
    Programme programme;

    public Actor(Programme programme) {
        this.programme = programme;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0)
                this.programme.play("陈情令播放中...");
            else
                this.programme.play("广告播放中...");

        }
    }
}
//观众-消费者
class Audience extends Thread{
    Programme programme;

    public Audience(Programme programme) {
        this.programme = programme;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
           this.programme.watch();
        }
    }
}
//节目-产品
class Programme{
    //演员表演，观众等待
    //观众观看，演员等待
    String  TVName;//表演的节目
    boolean flag=true;

    //演
    public synchronized void play(String TVName){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了 " + TVName);
        //通知观众观看
        this.notifyAll();//唤醒
        this.TVName=TVName;
        this.flag=!this.flag;
    }

    //看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了 " + TVName);
        //通知演员表演
        this.notifyAll();
        this.flag=!this.flag;
    }
}