package com.antonio.ecommerce.service;

import com.antonio.ecommerce.dto.Purchase;
import com.antonio.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    //We´ll pass on that purchase DTO and then we´ll send back the purchase response
    public PurchaseResponse placeOder(Purchase purchase);
}
