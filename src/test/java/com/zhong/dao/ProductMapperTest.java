package com.zhong.dao;

import com.zhong.entity.Category;
import com.zhong.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @Resource
    ProductMapper productMapper;
    @Test
    public void insertProduct() {
        Product product = new Product("1234555",new Category("123"),"123","123",
                "123","123","123",123,123,1,new Date(),new Date());
        productMapper.insertProduct(product);
    }

    @Test
    public void getProductList() {
        productMapper.selectProductById("123");
    }


}