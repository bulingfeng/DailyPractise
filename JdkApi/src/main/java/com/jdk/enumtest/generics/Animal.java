package com.jdk.enumtest.generics;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-28
 */
public class Animal {
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void voice(){
        System.out.println("动物叫....");
    }
}
