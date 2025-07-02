package com.wangziyu.datestudy;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTest {
    private SimpleDateFormat dateTime=new SimpleDateFormat("yyyyMMdd230000");
    private String strDateTime="20210311230000";
    private String timePattern="yyyyMMddHHmmss";
    @Test
    public void test1() throws InterruptedException {
        for(int i=0;i<=100;i++) {
            Date date = new Date();
            System.out.println(dateTime.format(date));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void test2() throws InterruptedException, ParseException {
        Date date=new SimpleDateFormat(timePattern).parse(strDateTime);
        System.out.println(date);
    }

    @Test
    public void test3() throws InterruptedException, ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(timePattern);
        System.out.println(simpleDateFormat.parse("20210311230000"));
    }
}
