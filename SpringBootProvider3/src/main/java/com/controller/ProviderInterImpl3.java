package com.controller;

import com.wangziyu.Interfaces.ProviderInterface1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProviderInterImpl3 implements ProviderInterface1 {

    @Override
    public String providerInterface1() {
        System.out.println("进入springbootProvider3提供的服务");
        return "springbootProvider3";
    }
}
