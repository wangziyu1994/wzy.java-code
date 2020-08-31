package com.test;

import com.model.Parent;
import com.model.Son;
import com.model.Son1;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;

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
}
