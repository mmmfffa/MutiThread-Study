package com.mf._01_thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author mf
 * @create 2021-05-13-9:34
 */
//实现多线程同步下载图片
public class TestThread02 extends  Thread{
    private String url;
    private String name;

    public TestThread02(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread02 testThread01 = new TestThread02("https://i0.hdslb.com/bfs/face/6f81fe5cf95260f8d745d116d9884b0ee439f227.jpg@96w_96h_1c.webp","01.jpg");
        TestThread02 testThread02 = new TestThread02("https://i0.hdslb.com/bfs/feed-admin/10641bbc5189591221c00958f3458f33798c7caa.png","02.jpg");
        TestThread02 testThread03 = new TestThread02("https://static.tianyaui.com/global/bbs/web/static/images/nav_top_logo_35.png","03.jpg");
        testThread01.start();
        testThread02.start();
        testThread03.start();
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