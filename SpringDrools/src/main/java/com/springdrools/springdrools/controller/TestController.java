package com.springdrools.springdrools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-19
 * @RequestMapping的各项参数
 * https://blog.csdn.net/weixin_43453386/article/details/83419060
 */
@RequestMapping("/test")
@RestController
public class TestController {


    @GetMapping("hi")
    public String test(){
        return "success";
    }
}
