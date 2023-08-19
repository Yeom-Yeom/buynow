package com.example.buynow.product.controller;

import com.example.buynow.product.entity.Product;
import com.example.buynow.product.record.ProductListRecord;
import com.example.buynow.product.repository.ProductRepository;
import com.example.buynow.product.service.ProductService;
import com.example.buynow.response.ListResponseData;
import com.example.buynow.response.SingleResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/")
    public ListResponseData<ProductListRecord> all() { return ListResponseData.of(productService.findAllDesc()); }

    @GetMapping("category/{category}")
    public ListResponseData<Product> showCategory(@PathVariable String category){
        return ListResponseData.of(productRepository.findByCategoryOrderByIdDesc(category));
    }

    @GetMapping("detail/{id}")
    public SingleResponseData<Product> showDetail(@PathVariable Long id){
        return SingleResponseData.of(productRepository.findById(id));
    }
}
