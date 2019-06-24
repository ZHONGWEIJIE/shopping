package com.zhong.service;

import com.zhong.dto.OrderDto;
import com.zhong.entity.Order;
import com.zhong.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    public boolean addOrder(Order order);

    public boolean updateOrder(Order order);

    public boolean deleteOrder(String orderNo);

    public boolean addOrderItem(OrderItem orderItem);

    public boolean updateOrderItem(OrderItem orderItem);

    public boolean deleteOrderItem(OrderItem orderItem);

    /**
     * 根据订单id查询订单
     * @param orderNo
     * @return
     */
    public  Order getOrderByOrderNo(String orderNo);

    /**
     * 获取所有订单
     * @return
     */
    public List<Order> getAllOrder();

    /**
     * 根据订单状态查询订单
     * @param status
     * @return
     */
    public List<OrderDto> getOrderByStatus(int status);

    /**
     * 根据订单号查询订单详情
     * @param orderNo
     * @return
     */
    public OrderItem getOrderItemByOrderNo(String orderNo);

    /**
     * 获取封装好的订单详情
     * @param orderNo
     * @return
     */
    public OrderDto getOrderDtoByOrderNo(String orderNo);

}
