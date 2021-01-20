package com.ecommerce.products.services.Impl;

import com.ecommerce.products.Document.Category;
import com.ecommerce.products.Document.Products;
import com.ecommerce.products.repository.CategoryRepository;
import com.ecommerce.products.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServicesImpl implements CategoryServices {

    @Autowired
    CategoryRepository categoryRepository;

}
