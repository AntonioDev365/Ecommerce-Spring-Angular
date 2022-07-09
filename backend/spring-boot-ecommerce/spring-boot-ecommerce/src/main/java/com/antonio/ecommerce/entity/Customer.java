package com.antonio.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    //@Column is always optional, if it´s not indicate it will use the property name
    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    //A customer can have a collection of orders
    @OneToMany(mappedBy="customer",cascade =CascadeType.ALL )
    private Set<Order> orders=new HashSet<>();

    //Just a convenience method for adding new orders for this customer
    public void add(Order order){
        if(order!=null){
            if(orders==null){
                orders=new HashSet<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }



}
