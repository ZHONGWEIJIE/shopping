package com.zhong.service;

import com.zhong.entity.Category;

import java.util.List;

public interface CategoryService {


    public void insertCategory(Category category);


    public List<Category> getCategoryList();
}
