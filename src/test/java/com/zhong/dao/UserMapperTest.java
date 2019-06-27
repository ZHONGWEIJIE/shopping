package com.zhong.dao;

import com.zhong.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void getAll() {
        List<User> userList = userMapper.getAll();
        for (User u: userList) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void deleteUser() {
        String id = "10004";
        userMapper.deleteUser(id);
    }

//    @Test
//    public void getOne() {
//    }
//    @Test
//    public void queryUserById(){
//        String id = "0";
//        User user = userMapper.queryUserById(id);
//        System.out.println(user);
//
//    }

}