package com.example.buynow.product.service;

import com.example.buynow.product.record.ProductListRecord;
import com.example.buynow.product.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public List<ProductListRecord> findAllDesc(){
        return productRepository.findAllDesc().stream()
                .map(ProductListRecord::new)
                .collect(Collectors.toList());
    }

}
