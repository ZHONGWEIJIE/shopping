package com.zhong.dao;

import com.zhong.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderItemMapper {

    public void addOrderItem(OrderItem orderItem);

    public void updateOrderItem(OrderItem orderItem);

    public void deleteOrderItem(OrderItem orderItem);

    /**
     * 根据订单号查询订单详情
     * @param orderNo
     * @return
     */
    public OrderItem selectOrderItemByOrderNo(@Param("orderNo") String orderNo);



}
