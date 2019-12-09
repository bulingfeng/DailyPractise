package com.resource.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-09
 */
@RestController("/api")
public class HelloController {
    @PostMapping("/api/hi")
    public String say(String name) {
        return "hi , " + name;
    }
}
