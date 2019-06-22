package com.zhong.shopping;

import com.zhong.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        //转换成json格式
        User user= new User();
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.phone = phone;
//        this.recipient = recipient;
//        this.question = question;
//        this.answer = answer;
//        this.role = role;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//        this.gender = gender;
//        user.setAnswer("13","1234","21232@qq.com","");
        redisTemplate.opsForValue().set("user",user);
        User u1 = (User)redisTemplate.opsForValue().get("user");
        System.out.println(u1);
    }
}
