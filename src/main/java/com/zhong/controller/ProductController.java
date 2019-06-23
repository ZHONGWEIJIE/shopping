package com.zhong.controller;

import com.zhong.entity.Product;
import com.zhong.service.ProductService;
import com.zhong.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {


    @Resource
    ProductService productService;


    @GetMapping("/productList")
    public Result getProductList(){
        // TODO 用户判定
        List<Product> productList = productService.getProductList();
        Map<String,Object> map = new HashMap<>();
        map.put("productList",productList);
        return Result.makeSuccessResult(map);
    }


    @GetMapping("/product")
    public Result insertProduct(HttpServletRequest request,Product product){
        System.out.println(product.getId());
        return  null;
    }


}
