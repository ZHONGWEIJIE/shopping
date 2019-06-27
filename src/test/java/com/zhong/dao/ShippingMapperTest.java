package com.zhong.dao;

import com.zhong.entity.Shipping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Vincent Hy
 * @date 2019/6/27 3:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShippingMapperTest {

    @Resource
    ShippingMapper shippingMapper;

    @Test
    public void insert() {
    }

    @Test
    public void queryById() {
        String userId = "10001";
        Shipping shipping = shippingMapper.queryById(userId);
        System.out.println("result: " + shipping.toString());
    }
}