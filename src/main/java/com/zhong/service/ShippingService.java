package com.zhong.service;

import com.zhong.entity.Shipping;

public interface ShippingService {
    Shipping insertShipping();
    Shipping queryShipping(String id);
}
