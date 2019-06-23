package com.zhong.service;

import com.zhong.dto.OrderDto;
import com.zhong.entity.Order;

import java.util.List;

public interface OrderService {

    public boolean addOrder(Order order);

    public boolean updateOrder(Order order);

    public boolean deleteOrder(int orderNo);

    /**
     * 根据订单id查询订单
     * @param orderNo
     * @return
     */
    public  Order getOrderByOrderNo(int orderNo);

    /**
     * 根据订单状态查询订单
     * @param status
     * @return
     */
    public List<OrderDto> getOrderByStatus(int status);


}
