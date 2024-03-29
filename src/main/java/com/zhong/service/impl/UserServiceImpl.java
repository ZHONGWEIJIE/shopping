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
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        List<User> list = userMapper.getAll();
        return list;
    }

    @Override
    public User getUserByUserId(String userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public Boolean deleteUser(String id) {
        User user = getUserByUserId(id);
        if (user != null) {
            userMapper.deleteUser(id);
            return true;
        } else {
            return false;
        }
    }

//    @Override
//    public User checkLogin(String username, String password,HttpServletResponse response) {
//        User user = userMapper.queryUserByUserName(username);
//        if(user != null && user.getPassword().equals(password)){
//            String loginToken = IdGen.uuid();
//            Cookie cookie = new Cookie("loginToken",loginToken);
//            cookie.setPath("/");
//            cookie.setMaxAge(60 * 60 * 24 * 3);
//            response.addCookie(cookie);
//            return user;
//
//        }
//        return null;
//    }

//    @Override
//    public User ListUser(String id) {
//
//        return null;
//    }
//

//
//    @Override
//    public void updateUser(String id,String password) {
//        User user = userMapper.queryUserById(id);
//        if(user!=null){
//            if(!user.getPassword().equals(password)){
//                user.setPassword(password);
//            }
//            else{
//                System.out.println("same password!");
//            }
//        }
//        else{
//            System.out.println("have no this user!");
//        }
//
//    }

//    @Resource
//    UserDao userDao;
//
//    @Resource
//    UserLoginDao userLoginDao;
//
//

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
