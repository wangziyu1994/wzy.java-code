package com.mapper1;

import com.model.OrderJava;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {

    @Update("update orders set order_id=#{orderId},order_status=#{orderStatus},cust_name=#{custName} where goods_id=#{goodsId}")
    public int updateOrder(OrderJava orderJava);
}
