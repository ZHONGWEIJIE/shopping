package com.zhong.controller;

import com.zhong.entity.User;
import com.zhong.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/shopping")
@SessionAttributes("user")
public class UserController {

    @Resource
    private UserService userService;



    @RequestMapping(value = "/login")
    public String login(String username,String password) {
        return "login1231232"+password+username;
    }
    @RequestMapping(value = "/delete")
    public String deleteUser(String id){
        userService.deleteUser(id);
        return "delete";
    }
    @RequestMapping(value = "/updatePassword")
    public String updatePassword(String id,String username){
        userService.updateUser(id,username);
        return "update";
    }
    @RequestMapping(value = "/userlist")
    public String userList(){
        userService.listAll();
        return "userlist";
    }


//    @RequestMapping(value = "/outLogin")
//    public String outLogin(HttpServletRequest request, HttpServletResponse response) {
//        userService.outLogin(request, response);
//        return "redirect:/shopping/login";
//    }
}
