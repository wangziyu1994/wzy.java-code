package com.wangziyu.test;

import org.junit.jupiter.api.Test;

public class BooleanTest {
    @Test
    public void test1(){
        Boolean flag=false;
        flag=setBoolean(flag);
        System.out.println(flag);
    }

    public Boolean setBoolean(Boolean flag){
        flag=true;
        return flag;
    }
}
