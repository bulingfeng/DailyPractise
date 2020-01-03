package com.jdk.enumtest.interfacetest;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-03
 */
public class InterfaceTest {
    public static void main(String[] args) {
        test(new Task[0]);
    }

    public static void test(Task[] task){
        System.out.println("task:"+task);
    }
}
