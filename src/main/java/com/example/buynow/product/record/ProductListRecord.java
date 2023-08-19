package com.example.buynow.product.record;

import com.example.buynow.product.entity.Product;

public record ProductListRecord(Long id, String name, String price, String img, String category) {
    public ProductListRecord(Product entity){
        this(entity.getId(), entity.getName(), entity.getPrice(), entity.getImg(), entity.getCategory());
    }
}
