package com.controller;

import com.mapper1.OrderMapper;
import com.model.HelloUser;
import com.model.OrderJava;
import com.model.OrderUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;


    @PostMapping(value="/getOrder")

    public String getOrder(@RequestBody OrderUser user) {

        String lock= UUID.randomUUID().toString();
        OrderJava order = new OrderJava();
        System.out.println("姓名是:"+user.getUserName());
        synchronized(lock) {
            order.setOrderId(lock);
            order.setCustName(user.getUserName());
            order.setOrderStatus("1");
            order.setGoodsId("goods1");
            orderMapper.updateOrder(order);
        }
        return order.getOrderStatus();
    }
}
