package com.zhong.service;

import com.zhong.entity.Category;
import com.zhong.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {


    @Resource
    ProductService productService;

    @Test
    public void getProductList() {
    }

    @Test
    public void insertProduct() {
        Product product = new Product();
        product.setId("1234444");

        product.setCategoryId(new Category("123"));
        productService.insertProduct(product);
    }
}