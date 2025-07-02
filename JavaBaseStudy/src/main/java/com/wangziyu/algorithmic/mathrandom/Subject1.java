package com.wangziyu.algorithmic.mathrandom;

/**
 * 给定一个函数f() 1,5,6,7,9 能等概率返回1-5的随机数
 */
public class Subject1 {
    public static final int size = 10000;

    public static void main(String[] args) {
        sumf(1);
        sumf(2);
        sumf(3);
        sumf(4);
        sumf(5);
        System.out.println("0-1-------------------------");
        sumf1(0);
        sumf1(1);
        System.out.println("0-7-------------------------");
        sumf2(0);
        sumf2(1);
        sumf2(2);
        sumf2(3);
        sumf2(4);
        sumf2(5);
        sumf2(6);
        sumf2(7);
        System.out.println("0-6-------------------------");
        sumf3(0);
        sumf3(1);
        sumf3(2);
        sumf3(3);
        sumf3(4);
        sumf3(5);
        sumf3(6);
        System.out.println("0-1-------------------------");
        sumdealFunction1(0);
        sumdealFunction1(1);
    }


    //等概率返回1-5的随机数 不能改
    public static int f() {
        return (int) (Math.random() * 5 + 1);
    }


    //让f()等概率的返回0,1
    public static int f1() {
        int f = 0;
        do {
            f = f();
        } while (f == 3);
        return f = f < 3 ? 0 : 1;
    }

    public static void sumf(int X) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (f() == X) {
                count++;
            }
        }
        System.out.println((double) count / size);
    }

    public static void sumf1(int X) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (f1() == X) {
                count++;
            }
        }
        System.out.println((double) count / size);
    }


    //等概率返回0-7  用000-111表示 0-7  等概率表示每一位，那么就能等概率表示0-7
    public static int f2() {
        return (f1() << 2) + (f1() << 1) + (f1() << 0);
    }


    public static void sumf2(int X) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (f2() == X) {
                count++;
            }
        }
        System.out.println((double) count / size);
    }


    //根据0-7等概率返回，改为0-6等概率返回
    public static int f3() {
        int res=0;
        do{
            res=f2();
        }while(res==7);
        return res;
    }



    public static void sumf3(int X) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (f3() == X) {
                count++;
            }
        }
        System.out.println((double) count / size);
    }


    // 你只能知道，x会以固定概率返回0和1，但是x的内容，你看不到！改变成等概率返回0,1
    public static int function1() {
        return Math.random() < 0.84 ? 0 : 1;
    }


    //改变成等概率返回0,1
    //思路：00 01 10 11    返回01  10的概率是相等的 遇到00  11重做
    public static int dealFunction1(){
        int res=0;
        do{
            res=function1();
        }while(res==function1());

        return res;
    }



    public static void sumdealFunction1(int X) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (dealFunction1() == X) {
                count++;
            }
        }
        System.out.println((double) count / size);
    }



}
