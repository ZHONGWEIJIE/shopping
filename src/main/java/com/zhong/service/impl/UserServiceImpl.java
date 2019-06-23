package com.zhong.service.impl;

import com.zhong.dao.UserLoginDao;
import com.zhong.dao.UserMapper;
import com.zhong.entity.User;
import com.zhong.service.UserService;
import com.zhong.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User checkLogin(int id,String username, String password,HttpServletResponse response) {
        User user = userMapper.queryUserById(id);
        if(user != null && user.getPassword().equals(password)){
            String loginToken = IdGen.uuid();
            Cookie cookie = new Cookie("loginToken",loginToken);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(cookie);
            return user;

        }
        return null;
    }

//    @Resource
//    UserDao userDao;
//
//    @Resource
//    UserLoginDao userLoginDao;
//
//
//    @Override
//    public User getUserByUserId(int userId) {
//        return null;
//    }
//
//    @Override
//    public User checkLogin(int userId, String password, HttpServletResponse response) {
//        User  user = userLoginDao.queryUserByUserIdAndPassword(userId, password);
//        if(user==null)
//        {
//            return null;
//        }
//
//        String loginToken = IdGen.uuid();
//        Cookie cookie = new Cookie("loginToken",loginToken);
//        cookie.setPath("/");
//        cookie.setMaxAge(60 * 60 * 24 * 3);
//        response.addCookie(cookie);
//        return getUserByUserId(userId);
//    }
//
//    @Override
//    public void outLogin(HttpServletRequest request, HttpServletResponse response) {
//        String keyLoginToken = "loginToken";
//        Cookie[] cookies = request.getCookies();
//
//        //从cookie中匹配loginToken
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals(keyLoginToken)) {
//                String loginToken = cookie.getValue();
//               // redisDao.del("loginToken:" + loginToken);
//                break;
//            }
//        }
//        //从cookie中清除loginToken
//        Cookie cookie = new Cookie("loginToken", "");
//        cookie.setPath("/");
//        cookie.setMaxAge(60 * 60 * 24 * 3);
//        response.addCookie(cookie);
//    }
}
