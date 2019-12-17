package com.jdk.enumtest.proxy;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-17
 */
public class CookManager implements ICook {

    @Override
    public void dealWithFood() {
        System.out.println("food had been dealed with");
    }

    @Override
    public void cook() {
        System.out.println("cook food");
    }
}
