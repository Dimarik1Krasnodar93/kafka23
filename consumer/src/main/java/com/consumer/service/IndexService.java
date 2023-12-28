package com.consumer.service;

import com.consumer.dto.Student;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class IndexService {
    public static final String TOPIC_NAME_3 = "exmp_topic_3_";


    @KafkaListener(topics = TOPIC_NAME_3)
    public void getByTopicExample(Student student) {
        System.out.println(String.format("key %s value %s group %s", student));
    }

}
