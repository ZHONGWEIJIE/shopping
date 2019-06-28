package com.zhong.dao;

import com.zhong.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    void insertCategory(Category category);

    public Category selectCategoryById(String id);

    List<Category> getCategoryList();
}
