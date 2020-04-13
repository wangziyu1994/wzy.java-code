package com.wang.controller;

import com.wang.controller.InController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello implements InController {

    @GetMapping("/sayHello")
    public String sayHello() {
        System.out.println("服务方被调用了!");

        return "hello,world";
    }
}
