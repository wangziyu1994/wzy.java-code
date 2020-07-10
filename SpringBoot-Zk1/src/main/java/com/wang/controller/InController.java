package com.wang.controller;

//import org.springframework.cloud.netflix.feign.FeignClient;
import com.wang.config.FeignClientConfig;
        import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="SpringBoot-Zk1",configuration = FeignClientConfig.class)
public interface InController {

    @GetMapping("/sayHello")
    public String sayHello();
}
