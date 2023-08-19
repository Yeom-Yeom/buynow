package com.example.buynow.order.entity;

import com.example.buynow.product.entity.Product;
import com.example.buynow.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

@Entity
@Setter
@Table(name="order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String address;

    public Order(){

    }
    @Builder
    public Order(Product product, String username, String address){
        this.product = product;
        this.username = username;
        this.address = address;
    }
}
