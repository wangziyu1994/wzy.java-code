package com.wangziyu.service;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =
@QueueBinding(value = @Queue(value = "${mq.config.queue.info}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.info.routing.key}")
)
public class ConsumerDirect2 {

    @RabbitHandler
    public void receiveMsg(String msg){
        System.out.println("订阅INFO日志消息队列获得:"+msg);
    }
}
