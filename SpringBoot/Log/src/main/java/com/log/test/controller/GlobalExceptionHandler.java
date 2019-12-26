package com.log.test.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-26
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //其他未处理的异常   
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        return "全局异常处理";
    }
}
