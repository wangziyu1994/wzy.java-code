package com.wangziyu.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    /**
     * 测试普通模式从队列中获取消息
     * @param msg
     */
    @RabbitListener(queues="wzy.mq-queue")
    public void receiveMsg(String msg){
        System.out.println("从MQ中获取到的消息为"+msg);
    }






}
