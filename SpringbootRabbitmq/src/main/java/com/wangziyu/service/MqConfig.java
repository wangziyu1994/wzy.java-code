package com.wangziyu.service;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

@Bean(name="wzy.mq-queue")
    public Queue getQueue(){
        return  new Queue("wzy.mq-queue");
    }
}
