package com.antonio.ecommerce.controller;

import com.antonio.ecommerce.dto.Purchase;
import com.antonio.ecommerce.dto.PurchaseResponse;
import com.antonio.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse purchaseResponse =checkoutService.placeOder(purchase);

        return purchaseResponse; //Wil return the purchase response in JSON automatically done by spring boot
    }

}
