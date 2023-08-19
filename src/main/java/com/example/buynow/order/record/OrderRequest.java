package com.example.buynow.order.record;

import com.example.buynow.user.entity.User;
import lombok.Getter;

@Getter
public class OrderRequest {
    private Long productId;
    private String username;
    private String address;
}
