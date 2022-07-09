package com.antonio.ecommerce.service;

import com.antonio.ecommerce.dao.CustomerRepository;
import com.antonio.ecommerce.dto.Purchase;
import com.antonio.ecommerce.dto.PurchaseResponse;
import com.antonio.ecommerce.entity.Customer;
import com.antonio.ecommerce.entity.Order;
import com.antonio.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired //@Autowired is optional since we only have one constructor
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOder(Purchase purchase) {

        //retrieve the order info from dto
        Order order=purchase.getOrder();

        //generate tracking number
        String orderTrackingNumber=generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems= purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item)); //Lambda

        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer=purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);

    }

    //Unique id that is hard to guess and random
    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        //UUID:Universally Unique Identifier
        //Standardized methods for generating unique IDS
        return UUID.randomUUID().toString();
    }
}







