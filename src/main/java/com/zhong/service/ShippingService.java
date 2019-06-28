package com.zhong.service;

import com.zhong.entity.Shipping;
import com.zhong.entity.User;

import java.util.Date;


public interface ShippingService {
    Shipping insertShipping(String id, String userId, String receiverName, String receiverPhone, String receiverMobile, String receiverProvince, String receverCity, String receiverDistrict, String receiverAddress, String receiverZip, Date createTime, Date updateTime);
    String queryShipping(String id);
}
