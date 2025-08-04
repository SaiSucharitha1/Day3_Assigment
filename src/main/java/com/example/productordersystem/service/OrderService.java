package com.example.productordersystem.service;

import com.example.productordersystem.entity.Order;

public interface OrderService {
    Order placeOrder(Long productId, int quantity);
}
