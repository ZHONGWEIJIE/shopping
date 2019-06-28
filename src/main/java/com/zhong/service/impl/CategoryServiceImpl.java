package com.zhong.service.impl;

import com.zhong.dao.CategoryMapper;
import com.zhong.entity.Category;
import com.zhong.service.CategoryService;
import com.zhong.utils.IdGen;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public void insertCategory(String name) {
        Category category  = new Category();
        category.setName(name);
        category.setId(IdGen.uuid());
        category.setSortOrder(1);
        category.setParentId("0");
        categoryMapper.insertCategory(category);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
}
