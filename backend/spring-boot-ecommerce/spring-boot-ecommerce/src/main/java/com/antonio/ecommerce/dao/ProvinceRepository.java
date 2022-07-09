package com.antonio.ecommerce.dao;

import com.antonio.ecommerce.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("http://localhost:4200")
public interface ProvinceRepository extends JpaRepository<Province,Integer> {

    //Finding states by country code
    List<Province> findByCountryCode(@Param("code")String code);
   //http://localhost:8080/api/provinces/search/findByCountryCode?code=IN

}
