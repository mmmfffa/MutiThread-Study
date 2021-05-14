package com.mf._02_callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author mf
 * @create 2021-05-13-22:14
 */
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call(){
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
        return true;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://i0.hdslb.com/bfs/face/6f81fe5cf95260f8d745d116d9884b0ee439f227.jpg@96w_96h_1c.webp","01.jpg");
        TestCallable t2 = new TestCallable("https://i0.hdslb.com/bfs/feed-admin/10641bbc5189591221c00958f3458f33798c7caa.png","02.jpg");
        TestCallable t3 = new TestCallable("https://static.tianyaui.com/global/bbs/web/static/images/nav_top_logo_35.png","03.jpg");
        //创建执行服务：
        ExecutorService ser= Executors.newFixedThreadPool(3);
        // 提交执行：
        Future<Boolean> result1=ser.submit(t1);
        Future<Boolean> result2=ser.submit(t2);
        Future<Boolean> result3=ser.submit(t3);
       // 获取结果：
        boolean rs1=result1.get();
        boolean rs2=result1.get();
        boolean rs3=result1.get();
        //关闭服务:
       ser.shutdownNow();
    }
}
//下载器
class WebDownload{
    //下载方法
    public void downloader(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}