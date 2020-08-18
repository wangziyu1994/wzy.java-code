package com.test;

import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

    @org.junit.Test
    public void test() throws ParseException, UnsupportedEncodingException {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(sf.parse(""));
        String var1="你好你好我好";
        byte [] bt1=var1.getBytes("UTF-8");
        byte [] bt2=var1.getBytes("GBK");
        System.out.println(bt1.length);
        System.out.println(bt2.length);

        for(byte b:bt1){
            System.out.println(b);
        }
        System.out.println("=====================================");
        for(byte b:bt2){
            System.out.println(b);
        }

    }
}
