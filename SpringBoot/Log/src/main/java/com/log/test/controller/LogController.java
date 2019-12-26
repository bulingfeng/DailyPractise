package com.log.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-05
 */
@RestController
@Slf4j
public class LogController{
    public static final String message="hello,%s";
    public static final AtomicLong count=new AtomicLong(0);

    @GetMapping("/name")
    public String testLog(String name){
        log.info("name为:"+name);
        return String.format(message,name);
    }

    @GetMapping("/exception")
    public String testException(String name){
        if (StringUtils.isEmpty(name)){
            throw new RuntimeException("name为空");
        }
        return "success";
    }


}
