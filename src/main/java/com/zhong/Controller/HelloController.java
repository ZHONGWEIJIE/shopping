package com.zhong.controller;

import com.zhong.entity.User;
import com.zhong.dao.UserMapper;
import com.zhong.utils.Result;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/hello/{name}")
    public Result hello(@PathVariable String name, String number) {
        if (name.equals("11")) {
            return Result.makeFailResult("Bye");
        }

        return Result.makeSuccessResult("hello");
    }




    @GetMapping("/getUsers")
    public String getUsers(Model model) {
        List<User> users = userMapper.getAll();
        model.addAttribute("users", users);
        return "user/userList";
    }

    public Map<String,Object> JSONResult(int code,String message, Object data){
        Map<String,Object> result = new HashMap();
        result.put("code",code);
        result.put("message",message);
        result.put("data",data);
        return  result;

    }


}
