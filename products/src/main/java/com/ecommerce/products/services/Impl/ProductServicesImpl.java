package com.ecommerce.products.services.Impl;


import com.ecommerce.products.Document.Products;
import com.ecommerce.products.controller.PojoMerchantDetails;
import com.ecommerce.products.services.ProductsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.ecommerce.products.repository.ProductsRepository;


import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServicesImpl implements ProductsServices {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public Products save(Products prod) {
        Products products = productsRepository.save(prod);
        ObjectMapper objectMapper = new ObjectMapper();
        String serialObject = "";
        try {
            serialObject = objectMapper.writeValueAsString(products);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        PojoMerchantDetails pojoMerchantDetails = new PojoMerchantDetails(products.getMerchantId(),products.getMerchantName());
        String serialObject1 = "";
        try {
            serialObject = objectMapper.writeValueAsString(products);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send("updateTrigger", serialObject1);
        kafkaTemplate.send("search", serialObject);
        return products;
    }

    @Override
    public Products findByProductId(String productId) {
        return productsRepository.findByProductId(productId);
    }


    @Override
    public void deleteByProductId(String id) {
        productsRepository.deleteById(id);
    }

    @Override
    public List<Products> findAll() {
        Iterable<Products> productsIterable = productsRepository.findAll();
        List<Products> productsList = new ArrayList<>();
        productsIterable.forEach(productsList:: add);
        return productsList;
    }

    @Override
    public Products update(Products products) {
        return null;
    }

    @Override
    public ResponseEntity<Products> updateProducts(String productId, Products products) {

        Products prod  = productsRepository.findByProductId(productId);
        System.out.println("productId"+ products.getProductId());

        System.out.println(products.toString());
        System.out.println(prod.toString());

        if(products.getPrice() == 0){
            prod.setPrice(prod.getPrice());
        }
        else
        {
            prod.setPrice(products.getPrice());
        }

        if(products.getQuantity() == 0){
            prod.setQuantity(prod.getQuantity());
        }
        else
        {
            prod.setQuantity(products.getQuantity());
        }

        if(!StringUtils.isEmpty(products.getColor()))
        {
            prod.setColor(products.getColor());
        }

        if(!StringUtils.isEmpty(products.getGender()))
        {
            prod.setGender(products.getGender());
        }

        if(products.getAge() == 0){
            prod.setAge(prod.getAge());
        }
        else
        {
            prod.setAge(products.getAge());
        }

        if(!StringUtils.isEmpty(products.getProductName()))
        {
            prod.setProductName(products.getProductName());
        }
        if(!StringUtils.isEmpty(products.getDescription()))
        {
            prod.setDescription(products.getDescription());
        }
        if(!StringUtils.isEmpty(products.getCategoryName()))
        {
            prod.setCategoryName(products.getCategoryName());
        }
        if(!StringUtils.isEmpty(products.getImageUrl()))
        {
            prod.setImageUrl(products.getImageUrl());
        }

        prod.setMerchantName(prod.getMerchantName());
        prod.setMerchantId(prod.getMerchantId());

        System.out.println("final Prod"+ prod.toString());

        final Products updatedProduct = productsRepository.save(prod);
        return ResponseEntity.ok(updatedProduct);
    }

    @Override
    public List<Products> findByCategoryName(String categoryName) {
        Iterable<Products> productsIterable = productsRepository.findByCategoryName(categoryName);
        List<Products> productList = new ArrayList<>();
        productsIterable.forEach(productList:: add);
        return productList;
    }

    @Override
    public List<Products> findByProductName(String productName) {
        Iterable<Products> productsIterable = productsRepository.findByProductName(productName);
        List<Products> productList = new ArrayList<>();
        productsIterable.forEach(productList:: add);
        return productList;
    }

    @Override
    public List<Products> findByMerchantId(String merchantId) {
        Iterable<Products> productsIterable = productsRepository.findByProductName(merchantId);
        List<Products> productList = new ArrayList<>();
        productsIterable.forEach(productList:: add);
        return productList;
    }


}
