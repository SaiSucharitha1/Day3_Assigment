package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.producer.MessageProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final MessageProducer producer;
    private final ObjectMapper objectMapper;

    public OrderController(MessageProducer producer, ObjectMapper objectMapper) {
        this.producer = producer;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public String publishOrder(@RequestBody Order order) throws JsonProcessingException {
        String orderJson = objectMapper.writeValueAsString(order);
        producer.sendMessage(orderJson);
        return "Order published successfully!";
    }
}
