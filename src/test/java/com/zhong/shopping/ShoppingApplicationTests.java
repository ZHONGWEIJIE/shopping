package com.zhong.shopping;

import com.zhong.dao.GuestBookMapper;
import com.zhong.dao.ProductMapper;
import com.zhong.entity.GuestBook;
import com.zhong.entity.Product;
import com.zhong.utils.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingApplicationTests {

	@Resource
	StringRedisTemplate stringRedisTemplate;
	@Resource
	ProductMapper productMapper;

	@Resource
	GuestBookMapper guestBookMapper;


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


	@Test
	public void resultTest(){
		Result.makeResult(null,null);
	}

	@Test
	public void productTest(){
		List<Product> lst = productMapper.getProductList();
		System.out.println(lst);
	}
}
