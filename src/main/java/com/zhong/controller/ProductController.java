package com.zhong.controller;

import com.zhong.entity.Product;
import com.zhong.service.ProductService;
import com.zhong.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/Product")
public class ProductController {


    @Resource
    ProductService productService;


    @GetMapping("/getAll")
    public Result getProductList(){
        // TODO 用户判定
        List<Product> productList = productService.getProductList();
        Map<String,Object> map = new HashMap<>();
        map.put("productList",productList);
        return Result.makeSuccessResult(map);
    }


    @GetMapping("/postProduct")
    public Result insertProduct(Product product){
        productService.insertProduct(product);
        return  Result.makeSuccessResult();
    }


}
