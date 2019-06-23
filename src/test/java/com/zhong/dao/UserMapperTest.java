package com.zhong.dao;

import com.zhong.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    UserMapper userMapper;
    @Test
    public void getAll() {
    }

    @Test
    public void getOne() {
    }
    @Test
    public void queryUserById(){
        int id = 0;
        User user = userMapper.queryUserById(id);
        System.out.println(user);

    }
}