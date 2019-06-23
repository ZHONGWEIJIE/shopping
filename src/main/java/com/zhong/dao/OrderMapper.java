package com.zhong.dao;

import com.zhong.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    public void addOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrder(int orderNo);

    /**
     * 根据订单id查询订单
     * @param orderNo
     * @return
     */
    public  Order selectOrderByOrderNo(@Param("orderNo") int orderNo);

    /**
     * 根据订单状态查询订单
     * @param status
     * @return
     */
    public List<Order> selectOrderByStatus(@Param("status") int status);

}
