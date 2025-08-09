package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "order-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("📩 Received message from Kafka: " + message);
    }
}
