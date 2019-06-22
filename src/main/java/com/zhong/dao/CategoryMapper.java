package com.zhong.dao;

import com.zhong.entity.Category;

import java.util.List;

public interface CategoryMapper {

    void insertCategory(Category category);



    List<Category> getCategoryList();
}
