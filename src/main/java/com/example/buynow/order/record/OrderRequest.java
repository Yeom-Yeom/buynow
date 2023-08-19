package com.example.buynow.order.record;

import lombok.Getter;

@Getter
public class OrderRequest {
    private Long productId;
    private String customerName;
    private String shippingAddress;
}
