package com.zhong.service;

import com.zhong.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * 获取所有的商品
     * @return
     */
    public List<Product> getProductList(String categoryId);

    /**
     * 获取指定id商品
     * @return
     */
    public Product getProduct(String productId);



    //插入一条商品信息
    public void insertProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(String id);

}
