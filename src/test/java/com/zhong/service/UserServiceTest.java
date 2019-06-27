package com.zhong.service;

import com.zhong.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Vincent Hy
 * @date 2019/6/27 2:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void listAll() {
        List<User> userList = userService.listAll();
        for (User u: userList) {
            System.out.println(u.toString());
        }
    }
}