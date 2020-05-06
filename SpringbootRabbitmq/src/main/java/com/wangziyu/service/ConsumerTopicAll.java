package com.wangziyu.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =
@QueueBinding(value = @Queue(value = "${mq.config.queue.logs}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange1}", type = ExchangeTypes.TOPIC),
        key = "*.log.*")
)
public class ConsumerTopicAll {

    @RabbitHandler
    public void receiveMsg(String msg){
        System.out.println("订阅所有主题队列获得:"+msg);
    }
}
