package com.zhong.dao;

import com.zhong.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper    {

    void insertProduct(Product product);

    public Product selectProductById(String id);

    /**
     * 根据分类id获取商品
     * @return 商品列表
     */
    List<Product> getProductList();

    List<Product> getProductListByCategoryId(String CategoryId);
}
