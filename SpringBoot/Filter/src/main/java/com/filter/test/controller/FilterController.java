package com.filter.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-06
 */
@RestController
public class FilterController {

    @GetMapping("/filter")
    private String filterTest(){
        return "Test,Filter...";
    }

    @GetMapping("/test")
    private String filterTest2(){
        return "get请求没有带filter";
    }

    @GetMapping("/filter/test")
    private String filterTest3(){
        return "get请求地址为/filter/test";
    }
}
