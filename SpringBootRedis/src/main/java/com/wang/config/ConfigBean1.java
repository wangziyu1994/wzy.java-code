package com.wang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean1 {

    @Bean(name="wzybean1")
    public SentinelRedisConfig getSentinelRedisConfig(){
    return new SentinelRedisConfig();
    }

}
