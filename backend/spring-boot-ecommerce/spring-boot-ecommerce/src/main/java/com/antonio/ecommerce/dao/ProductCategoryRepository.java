package com.antonio.ecommerce.dao;

import com.antonio.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


//To don´t use the default, productCategory name of json entry and product-category the path
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategories", path="product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
