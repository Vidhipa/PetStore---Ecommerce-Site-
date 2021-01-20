package com.ecommerce.products.repository;

import com.ecommerce.products.Document.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {

    // adding at the base level only will have to add it to other
        List<Products> findProductsByProductName(String productName);
        Products findByProductId(String productId);
        long count();
        List<Products> findByCategoryName(String categoryName);
        List<Products> findByProductName(String productName);
        void deleteById(String id);
}
