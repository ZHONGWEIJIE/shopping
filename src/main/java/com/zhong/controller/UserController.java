package com.zhong.controller;

import com.zhong.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/shopping")
public class UserController {
    @Resource
    private UserService userService;



    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/outLogin")
    public String outLogin(HttpServletRequest request, HttpServletResponse response) {
        userService.outLogin(request, response);
        return "redirect:/shopping/login";
    }
}
