package com.zhong.dao;

import com.zhong.entity.OrderItem;
import com.zhong.utils.IdGen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderItemMapperTest {

    @Resource
    OrderMapper orderMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    OrderItemMapper orderItemMapper;

    @Test
    public void addOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(IdGen.uuid());
        orderItem.setOrderId(orderMapper.selectOrderByOrderNo(1));
        orderItem.setUserId(userMapper.queryUserById("123"));
        orderItem.setCreateTime(new Date());
        orderItemMapper.addOrderItem(orderItem);
    }

    @Test
    public void selectOne() {
        OrderItem orderItem = orderItemMapper.selectOrderItemByOrderNo(1);
        orderItem.setUpdateTime(new Date());
        orderItemMapper.updateOrderItem(orderItem);
    }

    @Test
    public void deletOne() {
        OrderItem orderItem = orderItemMapper.selectOrderItemByOrderNo(1);
        orderItemMapper.deleteOrderItem(orderItem);
    }
}
