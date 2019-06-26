package com.zhong.controller;

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


    @GetMapping("/getProduct/{categoryId}")
    public Result getProductList(@PathVariable String categoryId){
        // TODO 用户判定
        List<Product> productList = productService.getProductList(categoryId);
        Map<String,Object> map = new HashMap<>();
        map.put("productList",productList);
        return Result.makeSuccessResult(map);
    }


    @PostMapping("/postProduct")
    public Result insertProduct(Product product){
        System.out.println(product);
//        productService.insertProduct(product);

        return  Result.makeSuccessResult();
    }


}
