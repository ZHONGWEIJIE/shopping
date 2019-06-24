package com.zhong.dao;

import com.zhong.entity.Shipping;

public interface ShippingMapper {
    /**
     * 插入一条收货记录
     */
    Shipping insert();
    /**
     * 根据id查询收货记录
     */
    Shipping queryById(String id);

}
