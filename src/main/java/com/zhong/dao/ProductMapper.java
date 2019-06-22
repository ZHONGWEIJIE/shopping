package com.zhong.dao;

import com.zhong.entity.Product;

import java.util.List;

public interface ProductMapper    {

    void insertProduct(Product product);

    /**
     * 根据分类id获取商品
     * @return 商品列表
     */
    List<Product> getProductListByCategoryId();
}
