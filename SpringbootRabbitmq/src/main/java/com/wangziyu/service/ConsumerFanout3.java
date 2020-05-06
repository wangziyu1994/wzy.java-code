package com.wangziyu.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =
@QueueBinding(value = @Queue(value = "${mq.config.queue.red}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange2}", type = ExchangeTypes.FANOUT)
)
)
public class ConsumerFanout3 {


    @RabbitHandler
    public void receiveMsg(String msg)
    {
        System.out.println("red日志消息队列获得:"+msg);
    }
}
