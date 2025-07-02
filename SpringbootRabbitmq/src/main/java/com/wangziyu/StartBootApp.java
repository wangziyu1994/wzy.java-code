package com.wangziyu;

import com.wangziyu.service.Model1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartBootApp {

    public static void main(String args[]) {
        Model1 model1 = new Model1();
        model1.setuName("wangziyu");
        model1.setSex("男");
        SpringApplication.run(StartBootApp.class, args);

    }

}
