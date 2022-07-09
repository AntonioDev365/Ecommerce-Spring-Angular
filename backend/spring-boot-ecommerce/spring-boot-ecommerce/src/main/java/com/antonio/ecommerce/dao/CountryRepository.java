package com.antonio.ecommerce.dao;

import com.antonio.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")              //Entity class, primary key
@RepositoryRestResource(collectionResourceRel = "countries", path="countries") //Expose custom /countries endpoints
public interface CountryRepository extends JpaRepository<Country,Integer> {

}
