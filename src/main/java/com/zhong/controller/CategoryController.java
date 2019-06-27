package com.zhong.controller;

import com.zhong.entity.Category;
import com.zhong.service.CategoryService;
import com.zhong.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/Category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @GetMapping("/getAll")
    public Result getCategoryList() {
        List<Category> categoryList = categoryService.getCategoryList();
        Map<String, Object> map = new HashMap<>();
        map.put("categoryList", categoryList);
        return Result.makeSuccessResult(map);
    }

    @PostMapping("/post")
    public Result postCategory(String name) {
        System.out.println(name);
        categoryService.insertCategory(name);
        return Result.makeSuccessResult();
    }

}
