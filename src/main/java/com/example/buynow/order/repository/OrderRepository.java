package com.example.buynow.order.repository;

import com.example.buynow.order.entity.Order;
import com.example.buynow.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
