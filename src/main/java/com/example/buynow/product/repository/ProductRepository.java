package com.example.buynow.product.repository;

import com.example.buynow.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p ORDER BY p.id DESC")
    List<Product> findAllDesc();

    List<Product> findByCategoryOrderByIdDesc(String category);

    Optional<Product> findById(Long id);
}
