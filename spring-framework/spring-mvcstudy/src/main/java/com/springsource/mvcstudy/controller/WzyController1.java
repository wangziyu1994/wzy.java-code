package com.springsource.mvcstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WzyController1 {

	@RequestMapping(method = RequestMethod.POST,path = "wzycontroller1")
	public String doContro1(){
		System.out.println("进入wzycontroller1");
		return "WzyController1  res";
	}
}
