package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GateWay1 {

@RequestMapping(value="/gateway1",method= RequestMethod.GET)
@ResponseBody
    public String gateway1(){
    System.out.println("网关转发到provider1服务");
    //System.out.println("网关转发到provider1服务");
        return "GateWay To SpringProvider1";
    }
}
