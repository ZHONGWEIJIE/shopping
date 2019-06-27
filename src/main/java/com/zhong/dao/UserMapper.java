package com.zhong.dao;


import com.zhong.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    void deleteUser(String id);

    User queryUserById(String id);

    //User getOne(Integer id);

//    User queryUserByUserName(String username);
//    void updateUser(User user);
////    void insert(User user);
//
//    void update(User user);
//
//    void delete(Integer id);

}