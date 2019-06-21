package com.zhong.dao;

import com.zhong.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User queryUserById(int id);
    void updateUser(User user);
}
