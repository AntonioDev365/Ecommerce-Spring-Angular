package com.antonio.ecommerce.dao;

import com.antonio.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

//It is mandatory to add crossOrigin support to spring boot
//Web browsers will not allow script code to call APIS not on the same origin
//same origin is composed of scheme/protocol,hostname, port number
//http://localhost:4200 != http//localhost:8090
//have to add Cross-Origin Resource Sharing(CORS)
//this allows the app running on localhost:4200 make a call to the rest API
//the actual server our angular application is running on, accepts call from web browser scripts from this origin
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product,Long> {

    //Query method cause starts with findBy, it will match by category id, and will use this parameter value
    Page<Product> findByCategoryId(@RequestParam("id")Long id, Pageable pageable);
    //Select * from product where category_id=?
    //Spring data Rest automatically exposes endpoints localhost:8080/api/products/search/findByCategoryId?id=2
    //Page is a sublist of a list of objects, has important information, Pageable contains pagination information

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
    //Behind the scenes spring is going to process "Select * from Product p where p.name LIKE concat('%',:name,'%'), :name is String name
    //Containing means like  ...

}
