package com.zhong.dao;


import com.zhong.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    //User getOne(Integer id);

    User queryUserById(String id);
    void updateUser(User user);
    void deleteUser(int id);
//    void insert(User user);
//
//    void update(User user);
//
//    void delete(Integer id);

}