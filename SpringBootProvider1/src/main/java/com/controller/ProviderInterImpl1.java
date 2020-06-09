package com.controller;

import com.wangziyu.Interfaces.ProviderInterface1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProviderInterImpl1 implements ProviderInterface1 {




    @Override
    public   String  providerInterface1() {
           System.out.println("进入springbootProvider1提供的服务");
           return "springbootProvider1";
      //  return "springbootProvider1";
    }


    
}
