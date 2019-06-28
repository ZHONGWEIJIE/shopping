package com.zhong.dao;

import com.zhong.entity.Shipping;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShippingMapper {
    /**
     * 插入一条收货记录
     */
    void insert(Shipping shipping);
    /**
     * 根据id查询收货记录
     */
    Shipping queryById(String userId);

}
