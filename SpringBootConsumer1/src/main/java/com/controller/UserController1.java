package com.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController1 {

    @Value("${wangziyu.name}")
    private String param2;


    @RequestMapping(value="/userController1/getController")
    public String getController(String param1){
System.out.println("进入userController1/getController");
return param2;
    }
}
