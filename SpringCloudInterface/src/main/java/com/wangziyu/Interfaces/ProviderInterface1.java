package com.wangziyu.Interfaces;

import com.wangziyu.fallback.FeignFallBackMethod;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@FeignClient(name="${com.wzy.service1}",fallbackFactory = FeignFallBackMethod.class)
public interface ProviderInterface1 {

    @RequestMapping(value = "/provider/providerInterface1",method = RequestMethod.GET)
   @ResponseBody
    public String providerInterface1();
}
