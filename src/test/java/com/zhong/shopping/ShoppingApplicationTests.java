package com.zhong.shopping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingApplicationTests {

	@Resource
	StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void valueAddResitTest(){
		stringRedisTemplate.opsForValue().set("key","value");
	}

	@Test
	public void valueGetResitTest(){
		String value = stringRedisTemplate.opsForValue().get("key");
//		logger.info("value:{}", value);
		System.out.println(value);
	}

	@Test
	public void valueDelResitTest(){
		stringRedisTemplate.delete("key");
	}

	@Test
	public void valueTimeoutResitTest(){
		stringRedisTemplate.opsForValue().set("timeStep", new Date().getTime()+"", 2 , TimeUnit.MINUTES);
	}

	@Test
	public void valueTimeResitTest(){
		stringRedisTemplate.opsForValue().set("test", "100",10,TimeUnit.SECONDS);
	}


}
