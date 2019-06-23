package com.zhong.service.impl;

import com.zhong.dao.OrderMapper;
import com.zhong.dto.OrderDto;
import com.zhong.entity.Order;
import com.zhong.service.OrderService;
import com.zhong.utils.IdGen;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{

    @Resource
    OrderMapper orderMapper;

    @Override
    public boolean addOrder(Order order) {
        if(order==null)
            return false;
        order.setId(IdGen.uuid());
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
    public boolean deleteOrder(int orderNo) {
        orderMapper.deleteOrder(orderNo);
        return true;
    }

    @Override
    public Order getOrderByOrderNo(int orderNo) {
        return orderMapper.selectOrderByOrderNo(orderNo);
    }

    @Override
    public List<OrderDto> getOrderByStatus(int status) {
        List<Order> orderList = orderMapper.selectOrderByStatus(status);
        List<OrderDto> list = new ArrayList<>();
        for(Order order:orderList) {
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderNo(order.getOrderNo());
            orderDto.setNickName(order.getUserId().getNickname());
            orderDto.setReceiverName(order.getShippingId().getReceiverName());
            orderDto.setMobile(order.getShippingId().getReceiverMobile());
//            orderDto.setProductName();
        }
        return list;
    }
}
