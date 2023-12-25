package com.producer.service;

import com.producer.configuration.KafkaProducerConfig;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SenderService {
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String key, String value) {
        //в топик без partitions
        val future = kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, key, value);
        //в топик с partitions
        val future2
                = kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME_2,  2, key, value);
    }
}
