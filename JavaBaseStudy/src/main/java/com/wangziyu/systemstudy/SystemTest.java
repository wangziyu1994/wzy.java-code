package com.wangziyu.systemstudy;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Properties;

public class SystemTest {

    @Test
    public void test1(){
        Map<String,String> envmap=System.getenv();
        Properties properties=System.getProperties();
        envmap.forEach((key,value)->{
            System.out.println(key+"      "+value);
        });
        System.out.println("==========================================================");
        System.out.println(properties.toString());
    }

    @Test
    public void test2(){
        Map<String,String> envmap=System.getenv();
        System.getProperty("wangziyu.name");
    }
}
