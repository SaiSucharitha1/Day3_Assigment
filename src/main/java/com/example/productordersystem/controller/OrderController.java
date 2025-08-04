package com.example.productordersystem.controller;

import com.example.productordersystem.entity.Order;
import com.example.productordersystem.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestParam Long productId, @RequestParam int quantity) {
        return orderService.placeOrder(productId, quantity);
    }
}
