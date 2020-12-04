package com.test;

import com.mapper1.HelloMapper;
import com.model.*;
import com.netflix.servo.util.VisibleForTesting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {

    @Autowired
   private HelloMapper helloMapper;
    @Test
    public void test(){
        List<HelloUser> list= helloMapper.selectHelloLike(" ' or 1=1 or s_name like'");
        for(HelloUser h:list){
            System.out.println(h.toString());
        }
    }

    @Test
    public void test1() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Student.class);
        Marshaller ms = jc.createMarshaller();
        Student st = new Student();
        st.setClassName("邮件内容");
        st.setCommentHead("邮件主题");
        Subject sj=new Subject();
        sj.setScores("34");
        st.setSubject(sj);

        StringWriter writer = new StringWriter();
        ms.marshal(st, writer);
        String result = writer.toString();
        System.out.println("对象转XML字符串： "+ result +"\n");
        System.out.println("---------------------------------------- \n");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Student _XMLTest = (Student) unmarshaller
                .unmarshal(new StringReader(result));

        System.out.println("翻转XML为对象："+_XMLTest.getClassName());
    }

    @Test
    public void test3(){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for(int i=0;i<=10;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }



}
