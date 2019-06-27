package com.zhong.service.impl;

import com.zhong.dao.ShippingMapper;
import com.zhong.entity.Shipping;
import com.zhong.entity.User;
import com.zhong.service.ShippingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("ShippingService")
public class ShippingServiceImpl implements ShippingService {
    @Resource
    ShippingMapper shippingMapper;


    @Override
    public Shipping insertShipping(String id, String userId, String receiverName, String receiverPhone, String receiverMobile, String receiverProvince, String receverCity, String receiverDistrict, String receiverAddress, String receiverZip, Date createTime, Date updateTime) {
        Shipping shipping = new Shipping();
        shipping.setId(id);
        shipping.setUserId(userId);
        shipping.setReceiverName(receiverName);
        shipping.setReceiverPhone(receiverPhone);
        shipping.setReceiverMobile(receiverMobile);
        shipping.setReceiverProvince(receiverProvince);
        shipping.setReceiverCity(receverCity);
        shipping.setReceiverDistrict(receiverDistrict);
        shipping.setReceiverAddress(receiverAddress);
        shipping.setReceiverZip(receiverZip);
        shipping.setCreateTime(createTime);
        shipping.setUpdateTime(updateTime);
        shippingMapper.insert(shipping);
        return shipping;
    }

    @Override
    public String queryShipping(String id) {
        Shipping shipping = shippingMapper.queryById(id);
        String address = shipping.getReceiverCity() + shipping.getReceiverDistrict() + shipping.getReceiverAddress();
        return address;
    }
}
