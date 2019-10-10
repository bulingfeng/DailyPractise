package com.mvel;

import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-10
 * 参考博客
 * https://blog.csdn.net/SunnyYoona/article/details/75244442
 */
public class Example {
    public static void main(String[] args) {

        String expression = "a == empty && b == empty";
        Map<String, Object> paramMap =new HashMap<String, Object>();
        paramMap.put("a", "");
        paramMap.put("b", null);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object);
    }
}
