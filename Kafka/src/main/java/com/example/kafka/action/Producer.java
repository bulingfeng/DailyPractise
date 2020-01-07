package com.example.kafka.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-07
 */
@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("test", message);
    }

    public void sendMessage(String key, String message) {
        kafkaTemplate.send("test", key, message);
    }
}


