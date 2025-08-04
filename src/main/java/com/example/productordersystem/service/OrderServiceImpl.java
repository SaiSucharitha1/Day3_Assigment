package com.example.productordersystem.service;

import com.example.productordersystem.entity.Order;
import com.example.productordersystem.entity.Product;
import com.example.productordersystem.repository.OrderRepository;
import com.example.productordersystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderServiceImpl(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    @Override
    public Order placeOrder(Long productId, int quantity) {
        Product product = productRepo.findById(productId).orElseThrow();
        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        product.setStock(product.getStock() - quantity);
        productRepo.save(product);

        Order order = new Order();
        order.setProduct(product);
        order.setQuantity(quantity);
        return orderRepo.save(order);
    }
}
