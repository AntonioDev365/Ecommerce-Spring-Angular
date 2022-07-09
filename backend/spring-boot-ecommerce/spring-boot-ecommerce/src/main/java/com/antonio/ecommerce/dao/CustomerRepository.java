package com.antonio.ecommerce.dao;

import com.antonio.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//When a purchase come across, we will grab the customer, assemble it accodingly, and then we´ll save the actual customer
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
