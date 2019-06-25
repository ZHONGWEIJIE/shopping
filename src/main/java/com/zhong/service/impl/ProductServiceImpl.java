package com.zhong.service.impl;

import com.zhong.dao.ProductMapper;
import com.zhong.entity.Product;
import com.zhong.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public List<Product> getProductList(String categoryId) {
        if(categoryId!=null && "-1".equals(categoryId)){
            return productMapper.getProductList();
        }
        else{
            return productMapper.getProductListByCategoryId(categoryId);
        }

    }

    @Override
    public void insertProduct(Product product) {

        //对
        productMapper.insertProduct(product);
    }
}