package com.zhong.controller;


import com.zhong.entity.Category;
import com.zhong.service.CategoryService;
import com.zhong.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @GetMapping("/getAll")
    public Result getCategoryList(){
        List<Category> categoryList = categoryService.getCategoryList();
        Map<String,Object> map = new HashMap<>();
        map.put("categoryList",categoryList);
        return Result.makeSuccessResult(map);
    }

}
