package com.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class IndexService {
    public static final String TOPIC_NAME = "exmp_topic";
    @KafkaListener(topics = TOPIC_NAME)
    public void getByTopicExample(String key, String value) {
        System.out.println(String.format("key %s value %s", key, value));
    }
}
