package com.controller;

import com.model.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;




public interface HelloInter {
	@RequestMapping(value="/sayhello")
	public Student sayHello(Student student);
}
