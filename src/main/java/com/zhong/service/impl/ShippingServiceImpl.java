package com.zhong.service.impl;

import com.zhong.dao.ShippingMapper;
import com.zhong.entity.Shipping;
import com.zhong.service.ShippingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ShippingService")
public class ShippingServiceImpl implements ShippingService {
    @Resource
    ShippingMapper shippingMapper;
    @Override
    public Shipping insertShipping() {
        Shipping shipping = shippingMapper.insert();
        return shipping;

    }

    @Override
    public Shipping queryShipping(String id) {
        Shipping shipping = shippingMapper.queryById(id);
        return shipping;

    }
}
