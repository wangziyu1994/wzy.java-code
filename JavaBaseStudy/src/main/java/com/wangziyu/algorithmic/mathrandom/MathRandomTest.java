package com.wangziyu.algorithmic.mathrandom;

import org.junit.jupiter.api.Test;

public class MathRandomTest {
    public static int size=1000000;


    /**
     * [0,1)当中的一个任意数，且概率均匀
     */
    @Test
    public void testMathRandom1(){
        //[0,1)
        int count=0;
        for(int i=0;i<size;i++) {
            double d = Math.random();
            if(d<0.2){
                count++;
            }
        }
        System.out.println((double) count/size);
    }


    /**
     * [0,10) 当中的任意整数，且概率均匀
     */
    @Test
    public void testMathRandom2(){
        //[0,1)
        int count=0;
        for(int i=0;i<size;i++) {
            //[0,10)
            int d = (int)(Math.random()*10);
            if(d<=4){
                count++;
            }

        }
        System.out.println((double) count/size);
    }


    /**
     * [1,11) 当中的任意整数，且概率均匀
     */
    @Test
    public void testMathRandom3(){
        //[0,1)
        int count=0;
        for(int i=0;i<size;i++) {
            //[0,10)
            int d = (int)(Math.random()*10+1);
            if(d==10){
                count++;
            }
        }
        System.out.println((double) count/size);
    }



    /**
     * 任意的x，x属于[0,1)，[0,x)范围上的数出现概率
     */
    @Test
    public double testMathRandom4(){
        //[0,1)
        double X=Math.random();
        System.out.println("X"+"是"+X);
        int count=0;
        for(int i=0;i<size;i++) {
            double var=Math.random();
            if(var<=X){
                count++;
            }
        }
        double res1=(double) count/size;
        System.out.println("出现再[0,x]概率是"+res1);
        System.out.println("出现再[0,x]概率的平方是"+Math.pow(res1,2));
        return X;
    }



    /**
     * 返回[0,1)的一个小数
     * 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
     */
    @Test
    public void testMathRandom5(){
        double X=testMathRandom4();
        System.out.println("=====X-->X2的概率========");
        int count=0;
        for(int i=0;i<size;i++) {
            double var1=Math.random();
            double var2=Math.random();
            double result=Math.max(var1,var2);
            if(result<=X){
                count++;
            }
        }
        double res1=(double) count/size;
        System.out.println("两次Max的结果是"+res1);


    }



    @Test
    public double testMathRandom6(){
        //[0,1)
        double X=Math.random();
        System.out.println("X"+"是"+X);
        int count=0;
        for(int i=0;i<size;i++) {
            double var=Math.random();
            if(var<=X){
                count++;
            }
        }
        double res1=1-(double) count/size;
        System.out.println("出现再(x,1]概率是"+res1);
        System.out.println("出现再[x,1]概率的平方是"+Math.pow(res1,2));
        return X;
    }

    /**
     * 返回[0,1)的一个小数
     * 任意的x，x属于(x,1)，(x,1)范围上的数出现概率由原来的1-x调整为1-x的平方
     */
    @Test
    public void testMathRandom7(){
        double X=testMathRandom6();
        int count=0;
        for(int i=0;i<size;i++) {
            double var1=Math.random();
            double var2=Math.random();
            double result=Math.min(var1,var2);
            if(result>X){
                count++;
            }
        }
        double res1=(double) count/size;
        System.out.println("两次Min的结果是"+res1);

    }
}
