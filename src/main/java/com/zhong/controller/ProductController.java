package com.zhong.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.zhong.entity.Product;
import com.zhong.service.ProductService;
import com.zhong.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/Product")
public class ProductController {


    @Resource
    ProductService productService;


    @GetMapping("/getProductList/{categoryId}")
    public Result getProductList(@PathVariable String categoryId){
        // TODO 用户判定
        List<Product> productList = productService.getProductList(categoryId);
        Map<String,Object> map = new HashMap<>();
        map.put("productList",productList);
        return Result.makeSuccessResult(map);
    }

    @GetMapping("/getProduct")
    public Result getProduct(String productId){
        Product product = productService.getProduct(productId);
        Map<String,Object> map = new HashMap<>();
        map.put("product",product);
        return Result.makeSuccessResult(map);
    }

    @PostMapping("/insertProduct")
    public Result insertProduct(@RequestBody Product product){
        productService.insertProduct(product);
        return Result.makeSuccessResult();
    }

    @PostMapping("/updateProduct")
    public Result updateProduct(@RequestBody Product product){
        productService.insertProduct(product);
        return Result.makeSuccessResult();
    }

    @DeleteMapping("/deleteProduct")
    public Result deleteProduct(String id){
        System.out.println("result: " + id);
//        productService.deleteProduct(id);
        return Result.makeSuccessResult();
    }

}
