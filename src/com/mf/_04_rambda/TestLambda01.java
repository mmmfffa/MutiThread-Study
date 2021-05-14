package com.mf._04_rambda;

/**
 * @author mf
 * @create 2021-05-14-8:54
 */
//推导lambda表达式
public class TestLambda01 {
    //3.静态内部类
    static   class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("like Lambda2!");
        }
    }
    public static void main(String[] args) {
        Like like = new Like();
        like.lambda();
        Like2 like2 = new Like2();
        like2.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("like Lambda3!");
            }
        }
        Like3 like3 = new Like3();
        like3.lambda();

        //5.匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("like Lambda4!");
            }
        };
        like4.lambda();

        //6.简化终极版：Lambda
        ILike like5=()->{
            System.out.println("like Lambda5!");
        };
        like5.lambda();

    }
}
//1.定义一个函数式接口
interface ILike{
    void lambda();
}
//2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("like Lambda!");
    }
}