package com.springkafka.controller;

import com.alibaba.fastjson.JSONObject;
import com.springkafka.conf.ProducerConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-07
 */
@RestController
public class TestController {

    @Autowired
    ProducerConf producerConf;

    @GetMapping("/test")
    public String test(){
        System.out.println(JSONObject.toJSON(producerConf));
        return "success";
    }
}
