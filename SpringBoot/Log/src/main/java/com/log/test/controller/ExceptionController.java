package com.log.test.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-26
 */
public interface ExceptionController {
    /**
     * 参考文献：
     * https://juejin.im/post/5d370f936fb9a07eee5f0e13
     *
     * @param e
     * @return
     */
    //局部异常处理（ps：对于参数必填的400异常也会被此异常处理器捕获）
    @ExceptionHandler(Exception.class)
    default String exHandler(Exception e) {
        // 未知的异常做出响应   
        return "controller异常了";
    }
}
