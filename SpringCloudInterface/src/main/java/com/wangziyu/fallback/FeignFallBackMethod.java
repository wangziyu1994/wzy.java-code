package com.wangziyu.fallback;

import com.wangziyu.Interfaces.ProviderInterface1;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignFallBackMethod implements FallbackFactory<ProviderInterface1> {
    @Override
    public ProviderInterface1 create(Throwable throwable) {
        System.out.println("进入FeignClient断路器方法");
        return  () ->"ProviderInterface1"+"FeignClient"+"失败";//lambda表达式
    }
}
