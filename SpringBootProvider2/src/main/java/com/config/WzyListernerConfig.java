package com.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"/wzyListener.application"})
public class WzyListernerConfig implements InitializingBean {
    @Value("${wzyListener:null}")
    private String wzyListener;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("进入初始化WzyListernerConfig-bean方法");
        System.out.println(wzyListener);
    }



}
