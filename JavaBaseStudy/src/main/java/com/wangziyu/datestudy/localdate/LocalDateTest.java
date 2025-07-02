package com.wangziyu.datestudy.localdate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class LocalDateTest {
    private static String pattern="uuuu-MM-dd";
    public static void main(String[] args) {
        LocalDateTime l=LocalDateTime.of(2020,02,29,0,0);
        DateTimeFormatter df= DateTimeFormatter.ofPattern(pattern);

        System.out.println(l.getDayOfMonth());
        System.out.println(l.getHour());
        LocalDateTime lu=l.plusDays(1);
        System.out.println(df.format(l));
        System.out.println(df.format(lu));
    }
}
