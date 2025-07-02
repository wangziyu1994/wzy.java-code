package com.test;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.model.*;
import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;

import javax.xml.bind.JAXBException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    @Test
    public void test2() throws JAXBException {
        Son son=new Son();
        son.setName("徐文老秃驴1号");
        Son1 son1=new Son1();
        son1.setName("徐文老秃驴2号");
        String name1=getName(son);
        String name2=getName(son1);
        System.out.println(name1+":"+name2);
    }

    @Test
    public void test3() throws JAXBException {

        //BigDecimal bigDecimal=new BigDecimal("");
        BigDecimal bigDecimal1=new BigDecimal("0.00");
       // System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
    }

    public String getName(Parent parent){
        return parent.getName();
    }


    @Test
    public void test4(){
        LocalDateTime localDateTime=LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
       // String strL=dateTimeFormatter.format(null);
        LocalDate localDate=LocalDate.now();
        LocalDateTime localDateTime1=LocalDateTime.now().minusSeconds((long)0.001);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDate);
       // System.out.println(strL);
    }

    @Test
    public void test5() throws IllegalAccessException {
        Class clazz= Student.class;
        Student s=new Student();
        Subject sb=new Subject();
        sb.setScores("90");
        s.setSubject(sb);
        s.setClassName("dfdfdf");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("aaa",s);
        System.out.println("Json"+JSONObject.toJSONString(map));
       Field []field=clazz.getDeclaredFields();
        for (Field f:field
             ) {
            f.setAccessible(true);
            System.out.println(f.get(s)+""+f.get(s).getClass()+" "+f.getType().isPrimitive()+" ");
        }
    }



    @Test
    public void test6() throws IllegalAccessException {

    Parent a=new Parent();
    a.setName("aaa");
    Parent b=new Parent();
    b=a;
    b.setName("bbbb");
    System.out.println(a.getName());
    }
}
