package com.example.buynow.product.record;

import com.example.buynow.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductRecord {
    private Long id;
    private String name;
    private String price;
    private String img;
    private String category;

    public ProductRecord(Product entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.img = entity.getImg();
        this.category = entity.getCategory();
    }
}
