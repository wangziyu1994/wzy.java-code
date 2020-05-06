package com.wangziyu.service;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =
@QueueBinding(value = @Queue(value = "${mq.config.queue.error1}", autoDelete = "false"), exchange = @Exchange(value = "${mq.config.exchange1}", type = ExchangeTypes.TOPIC),
        key = "*.log.error")
)
public class ConsumerTopic1 {

    @RabbitHandler
    public void receiveMsg(String msg){
        System.out.println("订阅error日志消息队列获得:"+msg);
    }
}
