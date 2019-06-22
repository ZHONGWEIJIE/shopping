package com.zhong.dao;

import com.zhong.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {

    @Resource
    CategoryMapper categoryMapper;

    @Test
    public void insertCategory() {
        Category category = new Category("1234","0","name",(short)1 ,1,new Date(),new Date());
        categoryMapper.insertCategory(category);

    }

    @Test
    public void getCategoryList() {
        List<Category> list = categoryMapper.getCategoryList();
        System.out.println(list);
    }
}