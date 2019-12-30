package com.jdk.enumtest.sigleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-30
 */
public class Person {
    private static Map<String,Object> ioc=new ConcurrentHashMap<String,Object>();

    public static Map<String, Object> getIoc() {
        return ioc;
    }

    public static void setIoc(Map<String, Object> ioc) {
        Person.ioc = ioc;
    }
}
