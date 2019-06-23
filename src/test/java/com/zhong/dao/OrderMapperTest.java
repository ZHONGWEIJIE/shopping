package com.zhong.dao;

import com.zhong.entity.Order;
import com.zhong.utils.IdGen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {


    @Resource
    OrderMapper orderMapper;

    @Test
    public void addOrder() {
        Order order = new Order();
        order.setId(IdGen.uuid());
        order.setOrderNo(1);
//        order.setUserId();
        order.setPayment(1220);
        orderMapper.addOrder(order);
    }

    @Test
    public void updateOrder() {
        Order order = orderMapper.selectOrderByOrderNo(1);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.updateOrder(order);
        System.out.println(order.getCreateTime());
    }

    @Test
    public void select() {
        List<Order> list = orderMapper.selectOrderByStatus(0);
        System.out.println(list.size());
    }

    @Test
    public void deleteOrder() {
        orderMapper.deleteOrder(1);
    }
}
