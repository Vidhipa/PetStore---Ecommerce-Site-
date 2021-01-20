package com.ecommerce.products.controller;


import com.ecommerce.products.Document.PojoQuantity;
import com.ecommerce.products.Document.Products;
import com.ecommerce.products.services.CategoryServices;
import com.ecommerce.products.services.ProductsServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {



    @Autowired
    ProductsServices productsServices;
    @Autowired
    CategoryServices categoryServices;

    private PojoMerchantDetails pojoMerchantDetails;
    private PojoProductDetails pojoProductDetails;
    // for finding all the products
    @CrossOrigin
    @GetMapping(value = "/findAll")
    List<Products> findAll(){
        return productsServices.findAll();
    }



    @CrossOrigin
    @GetMapping(value = "/findByproductId/{productId}")
    Products findByProductsId(@PathVariable String productsId){
        return productsServices.findByProductId(productsId);
    }



    @CrossOrigin
    @DeleteMapping(value = "/deleteproductById/{productId}")
    void deleteById(@PathVariable String productId){
        productsServices.deleteByProductId(productId);
    }

    @CrossOrigin
    @PostMapping(value = "")
    public Products save(@RequestBody Products products){
        return productsServices.save(products);

    }


    @CrossOrigin
    @GetMapping(value = "/findByCategoryName/{categoryName}")
    List<Products> findByCategoryName(@PathVariable String categoryName)
    {
        return productsServices.findByCategoryName(categoryName);
    }
    @CrossOrigin
    @PostMapping(value = "/{productId}")
    public ResponseEntity < Products > updateProducts(@PathVariable String productId,
                                                      @RequestBody Products productDetails){
        System.out.println(productId);
        return productsServices.updateProducts(productId,productDetails);
    }


    @CrossOrigin
    @GetMapping(value = "/findByProductName/{productName}")
    List<Products> findByProductsName(@PathVariable String productName)
    {
        return productsServices.findByProductName(productName);
    }

    @CrossOrigin
    @GetMapping (value = "/findByMerchantId/{merchantId}")
    List<Products> findByMerchantId(@PathVariable String merchantId){
        return productsServices.findByMerchantId(merchantId);
    }

    @KafkaListener(topics = "updateQuantity",groupId = "group_id")
    public void consume(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Products products ;
        PojoQuantity pojoQuantity = null;
        try {
            pojoQuantity = mapper.readValue(str.getBytes(), PojoQuantity.class);
            products = findByProductsId(pojoQuantity.getProductId());
            products.setQuantity(products.getQuantity() - pojoQuantity.getQuantity());
            productsServices.updateProducts(products.getProductId(), products);
            System.out.println(pojoQuantity.getProductId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
