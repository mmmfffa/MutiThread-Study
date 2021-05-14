package com.mf._04_rambda;

/**
 * @author mf
 * @create 2021-05-14-9:11
 */
public class TestLambda02 {
    public static void main(String[] args) {
        //lambda简化
/*       ILove love=(int a)->{
           System.out.println("Love->"+a);
        };
        love.love(520);
        //简化1：去掉参数类型
        love=(a)->{
            System.out.println("Love->"+a);
        };
        love.love(50);
        //简化2：简化括号
        love= a->{
            System.out.println("Love->"+a);
        };
        love.love(550);
        //简化3：去掉花括号
        love=a-> System.out.println("Love->"+a);
        love.love(521);*/
        //总结：lambda表达式只能有一行代码情况下才能简化一行，多个参数也可以都都去但要加括号
        ILove love=(a,b,c)->{
            System.out.println("Love->"+a);
            System.out.println("Love->"+b);
            System.out.println("Love->"+c);
        };
        love.love(521,502,250);

    }
}
interface ILove{
    void love(int a,int b,int c);
}