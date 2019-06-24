package com.zhong.controller;

import com.zhong.dto.OrderDto;
import com.zhong.entity.Order;
import com.zhong.entity.OrderItem;
import com.zhong.service.OrderService;
import com.zhong.utils.PriceTransformation;
import com.zhong.utils.Result;
import com.zhong.utils.StatysInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/Order")
public class OrderController {

    @Resource
    OrderService orderService;

    /**
     * 所有订单获取接口
     * @param status
     * @return
     */
    @GetMapping({"/getOrderList"})
    public Result getOrderList(int status) {
        Map<String, Object> map = new HashMap<>();
        List<OrderDto> orderDtoList = orderService.getOrderByStatus(status);
        if(orderDtoList!=null&&orderDtoList.size()!=0) {
            map.put("orderList",orderDtoList);
            return Result.makeSuccessResult(map);
        }
        return Result.makeResult("200",new StatysInfo("没有订单","暂时没有订单信息"));
    }

    /**
     * 单条订单接口获取
     * @param orderNo
     * @return
     */
    @GetMapping({"/getOneOrder/{orderNo}"})
    public Result getOneOrder(@PathVariable String orderNo) {
        Map<String, Object> map = new HashMap<>();
        OrderDto orderDto = orderService.getOrderDtoByOrderNo(orderNo);
        if(orderDto!=null) {
            map.put("order",orderDto);
            return Result.makeSuccessResult(map);
        }
        return Result.makeResult("500",new StatysInfo("没有订单详细内容","没有找到该订单详细内容"));
    }

    /**
     * 更新单条订单
     * @param
     * @return
     */
    @PostMapping({"/updateOrder"})
    public Result updateOneOrder(String orderNo,int quantity,int status,double price) {
        if(orderNo==null||orderNo.equals("")) {
            return Result.makeResult("499",new StatysInfo("参数为空","订单号为空"));
        }
        Order order = orderService.getOrderByOrderNo(orderNo);
        OrderItem orderItem = orderService.getOrderItemByOrderNo(orderNo);
        order.setUpdateTime(new Date());
        order.setStatus(status);
        orderItem.setUpdateTime(new Date());
        orderItem.setQuantity(quantity);
        orderItem.setTotalPrice(PriceTransformation.YuanToBranch(price));
        //0-取消 10-未支付 20-已支付 40-已发货 50-交易成功 60-交易关闭
        if(status==40)
            order.setSendTime(new Date());
        if(status==20)
            order.setPaymentTime(new Date());
        if(status==50)
            order.setCloseTime(new Date());
        if(status==60)
            order.setEndTime(new Date());
        orderService.updateOrder(order);
        orderService.updateOrderItem(orderItem);
        return Result.makeResult("200",new StatysInfo("更新成功","订单更新成功"));
    }


    /**
     * 删除数据
     * @param orderNo
     * @return
     */
    @DeleteMapping({"/deleteOrder"})
    public Result deleteOneOrder(String orderNo) {
        if(orderNo==null||orderNo.equals("")) {
            return Result.makeResult("499",new StatysInfo("参数为空","订单号为空"));
        }
        orderService.deleteOrderItem(orderService.getOrderItemByOrderNo(orderNo));
        orderService.deleteOrder(orderNo);
        return Result.makeResult("200",new StatysInfo("删除成功","删除成功"));
    }

}
