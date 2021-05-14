package com.mf._03_proxy;

/**
 * @author mf
 * @create 2021-05-13-23:35
 */
//真实对象和代理对象实现同一个接口
    //好处：代理对象可以做很多事，真实对象只需要专注自己的事
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()->System.out.println("I LOVE YOU")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}
interface Marry{
    void HappyMarry();
}
//真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("mafu要结婚了");
    }
}
//代理角色
class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    public WeddingCompany() {

    }

    @Override
    public void HappyMarry() {
         before();
        this.target.HappyMarry();//真实角色
        after();
    }
    public void before(){
        System.out.println("Marry前");
    }
    public void after(){
        System.out.println("Marry后");
    }
}