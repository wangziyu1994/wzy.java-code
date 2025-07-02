package com.wangziyu.service;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =
@QueueBinding(value = @Queue(value = "${mq.config.queue.info1}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange1}", type = ExchangeTypes.TOPIC),
        key = "*.log.info")
)
public class ConsumerTopic2 {

    @RabbitHandler
    public void receiveMsg(String msg){
        System.out.println("订阅INFO日志消息队列获得:"+msg);
    }
}
