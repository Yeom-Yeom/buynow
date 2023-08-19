package com.example.buynow.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String category;

    @Builder
    public Product(String name, String price, String img, String category){
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
    }
}
