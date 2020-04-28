package com.wangziyu.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues="wzy.mq-queue")
    public void receiveMsg(String msg){
        System.out.println("从MQ中获取到的消息为"+msg);
    }
}
