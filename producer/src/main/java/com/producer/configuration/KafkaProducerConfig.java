package com.producer.configuration;

import com.google.gson.JsonSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaProducerConfig {
    public static final String TOPIC_NAME = "exmp_topic";
    public static final String TOPIC_NAME_2 = "exmp_topic_2";
    public static final String TOPIC_NAME_3 = "exmp_topic_3_";
    public static final String TOPIC_NAME_3 = "exmp_topic_3_";
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String addresses;

    @Bean
    public NewTopic example() {
        return TopicBuilder
                .name(TOPIC_NAME)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic example2() {
        return TopicBuilder
                .name(TOPIC_NAME_3)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic example3() {
        return TopicBuilder
                .name(TOPIC_NAME_2)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map <String, Object> config = new HashMap<>();
        config.put(BOOTSTRAP_SERVERS_CONFIG, addresses);
        config.put(BATCH_SIZE_CONFIG, 3);
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory2() {
        Map <String, Object> config = new HashMap<>();
        config.put(BOOTSTRAP_SERVERS_CONFIG, addresses);
        config.put(BATCH_SIZE_CONFIG, 3);
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> factory) {
        return new KafkaTemplate<>(factory);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate2(ProducerFactory<String, Object> factory) {
        return new KafkaTemplate<>(factory);
    }



}
