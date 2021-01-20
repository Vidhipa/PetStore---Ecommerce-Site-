package com.ecommerce.products.repository;

import com.ecommerce.products.Document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {

    //List<Category> findByCategoryName(String categoryName);

}
