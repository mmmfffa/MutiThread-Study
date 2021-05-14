package com.mf._07_Synchronized;

import com.sun.jnlp.ApiDialog;

/**
 * @author mf
 * @create 2021-05-14-16:04
 */
//不安全的取钱
    //两个人去银行取钱，相同账户
public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000, "结婚基金");
        Drawing you = new Drawing(account, 50, "you");
        Drawing girlfriend = new Drawing(account, 70, "girlfriend");
        you.start();
        girlfriend.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+account.name+" 还剩余额 "+account.money);

    }
}
//账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread{
    Account account;//账户
    //取了多少钱
    int drawingMoney;
    //现在手中有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);//继承thread方法，name为线程名字
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    //synchronized加了同步之后还是不行，默认锁的是this
    @Override
    public  void run() {
        //锁的对象就是变化的量，需要增删改
        synchronized (account){

            if(account.money<drawingMoney) {
                System.out.println(Thread.currentThread().getName()+"==>您的余不足");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money-=drawingMoney;
            nowMoney+=drawingMoney;
            System.out.println(this.getName()+account.name + " 余额为 " + account.money);
            //this.getName()===Thread.currentThread().getName() 继承
            System.out.println(this.getName()+" 手里的钱有 " + nowMoney);
        }
    }
}