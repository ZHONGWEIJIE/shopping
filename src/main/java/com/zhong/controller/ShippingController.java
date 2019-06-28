package com.zhong.controller;

import com.zhong.entity.Shipping;
import com.zhong.service.ShippingService;
import com.zhong.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/shopping")
@SessionAttributes("shipping")
public class ShippingController {
    @Resource
    private ShippingService shippingService;



    @RequestMapping(value = "/insert")
    public Shipping insert() {

        return shippingService.insertShipping();
    }
    @RequestMapping(value = "/query")
    public Shipping checkShipping(String id){
        return shippingService.queryShipping(id);
    }
}
