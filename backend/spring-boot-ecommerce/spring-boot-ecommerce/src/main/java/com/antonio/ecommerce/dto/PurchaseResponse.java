package com.antonio.ecommerce.dto;

import lombok.Data;

//This class is to send back a Java object as JSON
@Data
public class PurchaseResponse {

    private  final String orderTrackingNumber;

}
