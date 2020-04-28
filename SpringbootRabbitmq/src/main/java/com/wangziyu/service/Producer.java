package com.wangziyu.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMsg() {
        String s = "往队列中放入的消息为:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());

        rabbitTemplate.convertAndSend("wzy.mq-queue",s+date);
    }
}
