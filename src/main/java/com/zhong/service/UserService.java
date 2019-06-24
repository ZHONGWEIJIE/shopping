package com.zhong.service;
import com.zhong.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
    //User getUserByUserId(int userId);



    /**
     *获取用户列表
     */
    List<User> listAll();



    User checkLogin(String username, String password,HttpServletResponse response);
    /**
     * 用户管理列表
     */
    User ListUser(String id);
    /**
     * 删除用户
     */
    void deleteUser(String id);
    /**
     * 修改信息
     */
    void updateUser(String id,String password);
    /**
     * 退出登录
     *
     * @param request  客户端请求
     * @param response 服务器响应
     */
   // void outLogin(HttpServletRequest request, HttpServletResponse response);
}
