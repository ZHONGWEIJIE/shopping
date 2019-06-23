package com.zhong.service;

import com.zhong.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * 获取所有的商品
     * @return
     */
    public List<Product> getProductList();



    //插入一条商品信息
    public void insertProduct(Product product);


}
