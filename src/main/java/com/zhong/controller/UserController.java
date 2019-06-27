package com.zhong.controller;

import com.zhong.entity.User;
import com.zhong.service.UserService;
import com.zhong.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/shopping")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/userlist")
    public Result userList() {
        List<User> userList = userService.listAll();
        Map<String, Object> map = new HashMap<>();
        map.put("userList", userList);
        return Result.makeSuccessResult(map);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(String userId) {
        if (userService.deleteUser(userId)) {
            return Result.SUCCESS_CODE;
        } else {
            return Result.FAIL_CODE;
        }
    }

//    @RequestMapping(value = "/login")
//    public String login(String username, String password, HttpServletResponse response) {
//        userService.checkLogin(username, password, response);
//        return "login";
//    }
//

//
//    @RequestMapping(value = "/updatePassword")
//    public String updatePassword(String id, String username) {
//        userService.updateUser(id, username);
//        return "update";
//    }


//    @RequestMapping(value = "/outLogin")
//    public String outLogin(HttpServletRequest request, HttpServletResponse response) {
//        userService.outLogin(request, response);
//        return "redirect:/shopping/login";
//    }
}
