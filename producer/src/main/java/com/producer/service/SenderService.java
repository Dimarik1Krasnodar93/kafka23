package com.producer.service;

import com.producer.configuration.KafkaProducerConfig;
import com.producer.domain.StringCallbackListener;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SenderService {
    private KafkaTemplate<String, String> kafkaTemplate;
    StringCallbackListener stringCallbackListener;


    public void sendMessage(String key, String value) {
        //в топик
        val future = kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, key, value);
        //без топика
        var futureDefault = kafkaTemplate.sendDefault(key, value);
    }
}
