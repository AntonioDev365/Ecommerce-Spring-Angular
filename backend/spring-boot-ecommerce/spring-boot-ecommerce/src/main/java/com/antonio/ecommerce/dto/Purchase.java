package com.antonio.ecommerce.dto;

import com.antonio.ecommerce.entity.Address;
import com.antonio.ecommerce.entity.Customer;
import com.antonio.ecommerce.entity.Order;
import com.antonio.ecommerce.entity.OrderItem;
import lombok.Data;
//DTOs to serve as a data structure to pass data between the Angular frontend and Spring Boot backend.
import java.util.Set;

//Purchase compose of Customer, Shipping Address, Billing Address, Order and OrderItem[]
@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems; //we can work between set and JSON array
}
