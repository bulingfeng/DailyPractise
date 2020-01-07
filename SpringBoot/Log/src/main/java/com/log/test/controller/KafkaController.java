package com.log.test.controller;

import com.log.test.action.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-07
 */
@RestController
public class KafkaController {

    @Autowired
    private Producer producer;

    @GetMapping("/send")
    public void send(String message){
        producer.sendMessage(message);
    }
}
