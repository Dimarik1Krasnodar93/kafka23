package com.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @KafkaListener(topics = "your-topic")
    public void getByTopic() {

    }
}
