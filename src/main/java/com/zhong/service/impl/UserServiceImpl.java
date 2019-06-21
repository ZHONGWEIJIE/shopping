package com.zhong.service.impl;

import com.zhong.dao.UserDao;
import com.zhong.dao.UserLoginDao;
import com.zhong.entity.User;
import com.zhong.service.UserService;
import com.zhong.utils.DemoUtil;
import com.zhong.utils.IdGen;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserLoginDao userLoginDao;

    public UserServiceImpl(UserDao userDao, UserLoginDao userLoginDao) {
        this.userDao = userDao;
        this.userLoginDao = userLoginDao;
    }

    @Override
    public User getUserInfoByUserId(int userId) {
        return null;
    }

    @Override
    public User checkLogin(int userId, String password, HttpServletResponse response) {
        User  user = userLoginDao.queryUserByUserIdAndPassword(userId, password);
        if(user==null)
        {
            return null;
        }

        String loginToken = IdGen.uuid();
        Cookie cookie = new Cookie("loginToken",loginToken);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 3);
        response.addCookie(cookie);
        return getUserInfoByUserId(userId);
    }

    @Override
    public void outLogin(HttpServletRequest request, HttpServletResponse response) {
        String keyLoginToken = "loginToken";
        Cookie[] cookies = request.getCookies();

        //从cookie中匹配loginToken
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(keyLoginToken)) {
                String loginToken = cookie.getValue();
               // redisDao.del("loginToken:" + loginToken);
                break;
            }
        }
        //从cookie中清除loginToken
        Cookie cookie = new Cookie("loginToken", "");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 3);
        response.addCookie(cookie);
    }
}
