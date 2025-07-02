package com.wangziyu.jvmstudy.runtimedataspacestudy;

import org.junit.jupiter.api.Test;

public class JvmStackTest {

    @Test
    public void test1(){
        int a=8;
        a=a+1;
    }


    @Test
    public void test2(){
        int a=8;
        a=a++;
    }


    @Test
    public void test3(){
        int a=8;
        a=++a;
    }

    @Test
    public void test4(){
        int a=0;
        a=a+1;
    }

    @Test
    public void test6(){
        int a=0;
        a=a+1;
    }

    @Test
    public void test5(){
        int a=10000000;
        a=a+1;
    }
}
