package com.zhong.dao;

import com.zhong.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    public void addOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrder(String orderNo);

    /**
     * 根据订单id查询订单
     * @param orderNo
     * @return
     */
    public  Order selectOrderByOrderNo(@Param("orderNo") String orderNo);

    /**
     * 根据订单状态查询订单
     * @param status
     * @return
     */
    public List<Order> selectOrderByStatus(@Param("status") int status);

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> selectAllOrder();
}
