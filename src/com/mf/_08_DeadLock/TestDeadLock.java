package com.mf._08_DeadLock;

/**
 * @author mf
 * @create 2021-05-14-17:20
 */
//死锁：多个线程互相持有对方手里资源并请求对方资源然后陷入死锁
public class TestDeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "g1");
        MakeUp g2 = new MakeUp(1, "g2");
        g1.start();
        g2.start();

    }
}
//口红
class Lipstick{

}
//镜子
class Mirror{

}
class MakeUp extends Thread{
    //需要的资源只有一份，用static 保证
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();

    int choice;//选择

    public MakeUp(int choice, String girlName) {
        super(girlName);
        this.choice = choice;
    }

    @Override
    public void run() {
        //化妆
        makeup();
    }
   //互相持有对方的的资源，并相互请求对方资源
    private void makeup(){
       if(choice==0){
           synchronized (lipstick){//获得口红的锁
               System.out.println(this.getName()+" 获得口红");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
           //一秒后想获得镜子
           synchronized (mirror){//获得口红的锁
               System.out.println(this.getName()+" 获得镜子");
           }


       }else {
           synchronized (mirror){
               System.out.println(this.getName()+" 获得镜子");
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           //放到同步外面，表示，请求lipstick后可以释放mirror这把锁
           synchronized (lipstick){
               System.out.println(this.getName()+" 获得口红");
           }

       }

    }
}