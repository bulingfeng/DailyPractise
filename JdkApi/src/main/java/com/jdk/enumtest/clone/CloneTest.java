package com.jdk.enumtest.clone;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-28
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Man man=new Man();

        man.setAge(18);
        man.setName("lingfeng");

        Man copyMan=man.clone();

        System.out.println(copyMan.getAge()==man.getAge());
        System.out.println(copyMan.getName()==man.getName());
        System.out.println(man==copyMan);
    }
}
