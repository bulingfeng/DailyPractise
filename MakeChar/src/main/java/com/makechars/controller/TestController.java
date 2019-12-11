package com.makechars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-11
 */
// 这里不能用RestController 否则返回的是一个json数据
@Controller
public class TestController {

    @RequestMapping("/index")
    public String hello() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:static/images/cc.png");
        return "index";
    }
}
