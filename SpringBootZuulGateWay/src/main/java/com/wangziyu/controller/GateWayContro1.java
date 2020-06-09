package com.wangziyu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GateWayContro1 {

    @RequestMapping(value = "/gatewayController1",method = RequestMethod.GET)
    @ResponseBody
    public String gatewaycon(){
        return "gatewayController1";
    }
}
