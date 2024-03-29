package com.zhong.controller;

import com.zhong.entity.Shipping;
import com.zhong.entity.User;
import com.zhong.service.ShippingService;
import com.zhong.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/shopping")
public class ShippingController {
    @Resource
    private ShippingService shippingService;


    @RequestMapping(value = "/insert")
    public Shipping insertShipping(String id, String userId, String receiverName, String receiverPhone, String receiverMobile, String receiverProvince, String receverCity, String receiverDistrict, String receiverAddress, String receiverZip, Date createTime, Date updateTime) {

        return shippingService.insertShipping(id, userId, receiverName, receiverPhone, receiverMobile, receiverProvince, receverCity, receiverDistrict, receiverAddress, receiverZip, createTime, updateTime);
    }

    @RequestMapping("/query")
    public Shipping checkShipping(String id) {
        return null;
//        return shippingService.queryShipping(id);
    }
}
