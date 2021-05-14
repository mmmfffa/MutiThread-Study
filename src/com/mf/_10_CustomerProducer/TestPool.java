package com.mf._10_CustomerProducer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mf
 * @create 2021-05-14-19:19
 */
//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //1.创建池子
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.启动
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //3.关闭连接
        service.shutdown();


    }
}
class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行...");
    }
}