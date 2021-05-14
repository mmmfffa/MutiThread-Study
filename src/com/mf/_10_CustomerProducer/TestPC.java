package com.mf._10_CustomerProducer;

/**
 * @author mf
 * @create 2021-05-14-18:25
 */
//测试：生产者消费者模型--》利用缓冲区解决：管程法
    //生产者，消费之，产品，缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContain synContain = new SynContain();
        new Producer(synContain).start();
        new Customer(synContain).start();
    }
}
//生产者
class Producer extends Thread{
    SynContain synContain;

    public Producer(SynContain synContain) {
        this.synContain = synContain;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContain.push(new Chicken(i));
            System.out.println("生产了第 " + i + " 只鸡");
        }
    }
}
//消费者
class Customer extends Thread{
    SynContain synContain;

    public Customer(SynContain synContain) {
        this.synContain = synContain;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第 " + synContain.pop().id + " 只鸡");
        }
    }
}
//产品
class Chicken{
   int id;

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContain{
    //需要一个容器大小
    Chicken[] chickens=new Chicken[10];
    int count=0;
    //生产者放入
    public synchronized void push(Chicken chicken){
        //如果容器满了，通知消费者消费，生产者等待
        if(count==chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满就生产
        chickens[count]=chicken;
        count++;
        this.notifyAll();
    }
    //消费者消费
    public synchronized Chicken pop(){
        //如果容器为0，通知生产者生产，消费者等待
        if(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果不为0就消费
        count--;
        Chicken chicken = chickens[count];
        //通知生产者已消费
        this.notifyAll();
        return chicken;
    }
}