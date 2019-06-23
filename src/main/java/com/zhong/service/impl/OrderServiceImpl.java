package com.zhong.service.impl;

import com.zhong.dao.OrderItemMapper;
import com.zhong.dao.OrderMapper;
import com.zhong.dto.OrderDto;
import com.zhong.entity.Order;
import com.zhong.entity.OrderItem;
import com.zhong.service.OrderService;
import com.zhong.utils.IdGen;
import com.zhong.utils.OrderGen;
import com.zhong.utils.PriceTransformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{

    @Resource
    OrderMapper orderMapper;
    @Resource
    OrderItemMapper orderItemMapper;

    @Override
    public boolean addOrder(Order order) {
        if(order==null)
            return false;
        order.setId(IdGen.uuid());
        order.setOrderNo(OrderGen.orderId());
        orderMapper.addOrder(order);
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        if(order==null)
            return false;
        orderMapper.updateOrder(order);
        return true;
    }

    @Override
    public boolean deleteOrder(String orderNo) {
        orderMapper.deleteOrder(orderNo);
        return true;
    }

    @Override
    public boolean addOrderItem(OrderItem orderItem) {
        if(orderItem==null)
            return false;
        orderItem.setId(IdGen.uuid());
        orderItemMapper.addOrderItem(orderItem);
        return true;
    }

    @Override
    public boolean updateOrderItem(OrderItem orderItem) {
        if(orderItem==null)
            return false;
        orderItemMapper.updateOrderItem(orderItem);
        return true;
    }

    @Override
    public boolean deleteOrderItem(OrderItem orderItem) {
        if(orderItem==null)
            return false;
        orderItemMapper.deleteOrderItem(orderItem);
        return true;
    }

    @Override
    public Order getOrderByOrderNo(String orderNo) {
        return orderMapper.selectOrderByOrderNo(orderNo);
    }

    @Override
    public List<OrderDto> getOrderByStatus(int status) {
        List<Order> orderList = orderMapper.selectOrderByStatus(status);
        List<OrderDto> list = new ArrayList<>();
        for(Order order:orderList) {
            OrderDto orderDto = new OrderDto();
            OrderItem orderItem = orderItemMapper.selectOrderItemByOrderNo(order.getOrderNo());
            orderDto.setOrderNo(order.getOrderNo());
            orderDto.setNickName(order.getUserId().getNickname());
            orderDto.setReceiverName(order.getShippingId().getReceiverName());
            orderDto.setMobile(order.getShippingId().getReceiverMobile());
            orderDto.setProductName(orderItem.getProductName());
            orderDto.setDetail(orderItem.getProductId().getDetail());
            orderDto.setQuantity(orderItem.getQuantity());
            orderDto.setPrice(PriceTransformation.BranchToYuan(orderItem.getTotalPrice()));
            orderDto.setStatus(order.getStatus());
            orderDto.setUpdateTime(order.getUpdateTime());
            list.add(orderDto);
        }
        return list;
    }

    @Override
    public OrderItem getOrderItemByOrderNo(String orderNo) {
        return orderItemMapper.selectOrderItemByOrderNo(orderNo);
    }

    @Override
    public OrderDto getOrderDtoByOrderNo(String orderNo) {
        Order order = getOrderByOrderNo(orderNo);
        OrderItem orderItem = getOrderItemByOrderNo(orderNo);
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderNo(order.getOrderNo());
        orderDto.setNickName(order.getUserId().getNickname());
        orderDto.setReceiverName(order.getShippingId().getReceiverName());
        orderDto.setMobile(order.getShippingId().getReceiverMobile());
        orderDto.setProductName(orderItem.getProductName());
        orderDto.setDetail(orderItem.getProductId().getDetail());
        orderDto.setQuantity(orderItem.getQuantity());
        orderDto.setPrice(PriceTransformation.BranchToYuan(orderItem.getTotalPrice()));
        orderDto.setStatus(order.getStatus());
        orderDto.setUpdateTime(order.getUpdateTime());
        return orderDto;
    }
}
