package com.wangziyu.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =
@QueueBinding(value = @Queue(value = "${mq.config.queue.warn}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange1}", type = ExchangeTypes.TOPIC),
        key = "*.log.warn")
)
public class ConsumerTopic3 {

    @RabbitHandler
    public void receiveMsg(String msg){
        System.out.println("订阅warn日志消息队列获得:"+msg);
    }
}
