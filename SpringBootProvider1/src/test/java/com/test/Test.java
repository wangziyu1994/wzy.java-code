package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

    @org.junit.Test
    public void test() throws ParseException {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.parse(""));
    }
}
