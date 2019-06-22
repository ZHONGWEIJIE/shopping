package com.zhong.dao;

import com.zhong.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {
    User queryUserById(int id);
    void updateUser(User user);
}
