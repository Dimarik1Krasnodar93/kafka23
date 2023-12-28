package com.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.producer.configuration.KafkaProducerConfig;
import com.producer.dto.Student;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SenderService {
    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaTemplate<String, Object> kafkaTemplate2;


    public void sendMessage(String key, String value) {
        //в топик без partitions
        val future = kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, key, value);
        //в топик с partitions
        val future2
                = kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME_2,  2, key, value);
        Student student = new Student();
        student.setAge(16);
        student.setName("Ivan");
        val future3 = kafkaTemplate2.send(KafkaProducerConfig.TOPIC_NAME_3, student);

    }
}
