package com.wangziyu.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings =
@QueueBinding(value = @Queue(value = "${mq.config.queue.error}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.error.routing.key}")
)
        public class ConsumerDirect1 {

       @RabbitHandler
        public void receiveMsg(String msg){
        System.out.println("订阅错误日志消息队列获得:"+msg);
        }
}
