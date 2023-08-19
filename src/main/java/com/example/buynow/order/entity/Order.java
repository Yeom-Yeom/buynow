package com.example.buynow.order.entity;

import com.example.buynow.product.entity.Product;
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
    private String customerName;
    @Column(nullable = false)
    private String shippingAddress;

    public Order(){

    }
    @Builder
    public Order(Product product, String customerName, String shippingAddress){
        this.product = product;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
    }
}
