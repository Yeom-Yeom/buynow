package com.example.buynow.order.controller;

import com.example.buynow.order.entity.Order;
import com.example.buynow.order.record.OrderRequest;
import com.example.buynow.order.repository.OrderRepository;
import com.example.buynow.product.entity.Product;
import com.example.buynow.product.repository.ProductRepository;
import com.example.buynow.response.SingleResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/order")
public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/create")
    public SingleResponseData<String> createOrder(@RequestBody OrderRequest orderRequest){
        Optional<Product> optionalProduct = productRepository.findById(orderRequest.getProductId());

        Product product = optionalProduct.get();
        Order order = new Order();
        order.setProduct(product);
        order.setCustomerName(orderRequest.getCustomerName());
        order.setShippingAddress(orderRequest.getShippingAddress());
        orderRepository.save(order);

        return SingleResponseData.of(orderRequest);
    }
}
