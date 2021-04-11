package com.wangziyu.test;

import org.junit.jupiter.api.Test;

public class TryCatchFinallyTest {
    @Test
    public void test1() {
        try {
            dosomethingWithReturn();
            System.out.println("未发现异常,通过");
        } catch (Exception e) {
            System.out.println("发现异常,捕获");
        }
    }


    public void dosomethingWithReturn() {
        try {
            throw new RuntimeException("运行时异常");
        } finally {
            System.out.println("finally块的语句执行");
            return;
        }
    }


        @Test
        public void test2() {
            try {
                dosomethingWithOutReturn();
                System.out.println("未发现异常,通过");
            } catch (Exception e) {
                System.out.println("发现异常,捕获");
            }
        }

        public void dosomethingWithOutReturn() {
            try {
                throw new RuntimeException("运行时异常");
            } finally {
                System.out.println("finally块的语句执行");
            }
        }


    @Test
    public void test3() {
        try {
            dosomethingWithBreak();
            System.out.println("未发现异常,通过");
        } catch (ArithmeticException e) {
            System.out.println("发现异常,捕获");
        }
    }

    public void dosomethingWithBreak() {
        try {
            throw new ArithmeticException("运行时异常");
        } finally {
           for(int i=0;i<=1;i++){
               if(i==1){
                   continue;
               }
           }
        }
    }
    }
