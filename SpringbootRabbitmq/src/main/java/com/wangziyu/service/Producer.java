package com.wangziyu.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange1}")
    private String exchangeName;


    @Value("${mq.config.exchange1}")
    private String exchangeName1;

    @Value("${mq.config.exchange2}")
    private String exchangeName2;
    /**
     * 测试普通模式往队列放入消息
     */
    public void sendMsg() {
        String s = "往队列中放入的消息为:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());

        rabbitTemplate.convertAndSend("wzy.mq-queue",s+date);
    }


    /**
     * 测试direct模式往队列放入消息
     */
    public void sendMsg1() {
        String s = "错误队列中的消息:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());
System.out.println("往错误队列中放入消息!");
        rabbitTemplate.convertAndSend(this.exchangeName,"log.error.routing.key",s+date);
    }

    /**
     * 测试direct模式往队列放入消息
     */
    public void sendMsg2() {
        String s = "INFO队列中的消息:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());
        System.out.println("往INFO队列中放入消息!");
        rabbitTemplate.convertAndSend(this.exchangeName,"log.info.routing.key",s+date);
    }


    /**
     * 测试topic模式往队列放入消息
     */
    public void sendMsg3() {
        String s = "user主题队列中的消息:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());
        System.out.println("user往主题队列中放入消息!");
        rabbitTemplate.convertAndSend(this.exchangeName1,"user.log.warn",s+"user.log.warn"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"user.log.info",s+"user.log.info"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"user.log.error",s+"user.log.error"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"user.log.debug",s+"user.log.debug"+date);
    }


    /**
     * 测试topic模式往队列放入消息
     */
    public void sendMsg4() {
        String s = "product主题队列中的消息:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());
        System.out.println("product往主题队列中放入消息!");
        rabbitTemplate.convertAndSend(this.exchangeName1,"product.log.warn",s+"product.log.warn"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"product.log.info",s+"product.log.info"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"product.log.error",s+"product.log.error"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"product.log.debug",s+"product.log.debug"+date);
    }


    /**
     * 测试topic模式往队列放入消息
     */
    public void sendMsg5() {
        String s = "order主题队列中的消息:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());
        System.out.println("order往主题队列中放入消息!");
        rabbitTemplate.convertAndSend(this.exchangeName1,"order.log.warn",s+"order.log.warn"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"order.log.info",s+"order.log.info"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"order.log.error",s+"order.log.error"+date);
        rabbitTemplate.convertAndSend(this.exchangeName1,"order.log.debug",s+"order.log.debug"+date);
    }

    /**
     * 测试fanout模式队列
     */
    public void sendMsg6(){
        String s = "广播模式队列中的消息:";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String date=sf.format(new Date());
        System.out.println("广播模式队列中放入消息!");
        rabbitTemplate.convertAndSend(this.exchangeName2,"",s+"all"+date);
    }
}
