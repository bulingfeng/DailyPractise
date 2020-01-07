package com.example.kafka.action;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-07
 */

@Component
@Slf4j
public class Consumer {
    @KafkaListener(topics = "test",groupId = "myGroup")
    public void listener(ConsumerRecord<String, String> record) {
        String value = record.value();
        log.info("【receive】:{}", value);
    }
}

