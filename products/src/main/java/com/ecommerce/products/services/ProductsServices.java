package com.ecommerce.products.services;

import com.ecommerce.products.Document.Products;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductsServices{
    Products save(Products prod);
    Products findByProductId(String productId);
    void deleteByProductId(String productId);
    List<Products> findAll();
    Products update(Products products);

    ResponseEntity<Products> updateProducts(String productId, Products products);
    List<Products> findByCategoryName(String categoryName);
    List<Products> findByProductName(String productName);

    List<Products> findByMerchantId(String merchantId);

}
