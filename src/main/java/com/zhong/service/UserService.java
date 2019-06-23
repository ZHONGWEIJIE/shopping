package com.zhong.service;

import com.zhong.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    //User getUserByUserId(int userId);
    User checkLogin(int id, String username, String password,HttpServletResponse response);

    /**
     * 退出登录
     *
     * @param request  客户端请求
     * @param response 服务器响应
     */
   // void outLogin(HttpServletRequest request, HttpServletResponse response);
}
