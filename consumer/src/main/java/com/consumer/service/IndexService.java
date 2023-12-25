package com.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    public static final String TOPIC_NAME = "exmp_topic";
    public static final String TOPIC_NAME_2 = "exmp_topic_2";
    @KafkaListener(topics = TOPIC_NAME)
    public void getByTopicExample(String key, String value,
                                  @Header(KafkaHeaders.GROUP_ID) String groupId) {
        System.out.println(String.format("key %s value %s group %s", key, value, groupId));
    }

    @KafkaListener(topics = TOPIC_NAME_2)
    public void getByTopicExample2(String key, String value,
                                   @Header(KafkaHeaders.GROUP_ID) String groupId) {
        System.out.println(String.format("topic 2: key %s value %s group %s", key, value,
                groupId));
    }
}
