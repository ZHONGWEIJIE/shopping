package com.zhong.dao;

import com.zhong.entity.User;

public interface UserDao {
    User queryUserById(int id);
    void updateUser(User user);
}
