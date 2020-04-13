package com.controller;


import com.wang.controller.InController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class consumer {

    @Autowired
  private InController inController;


    @GetMapping("/SpringBoot-Zk2/consume")
    public String consume (){
 System.out.println("消费方开始从zookeeper注册中心调用服务方hello服务了!");

       String result= inController.sayHello();
    System.out.println("消费方调用结束!结果为:"+result);
        return result;
    }
}
