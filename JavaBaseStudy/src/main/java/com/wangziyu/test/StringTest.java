package com.wangziyu.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringTest {
    @Test
    public void test1(){
        String str="sdfs@!@@!@";
        String[] strArr=str.split("@!@");
        String[] strArr1=str.split("@!@",-1);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(strArr1));
    }
}
