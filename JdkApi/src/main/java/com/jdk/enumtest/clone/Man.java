package com.jdk.enumtest.clone;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-28
 */
public class Man implements Cloneable{
    private String name;
    private int age ;

    //
    public Man clone() throws CloneNotSupportedException {
        return (Man) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
