package com.jdk.enumtest.lamd;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-28
 */
// 这个注解是
@FunctionalInterface
public interface Action {

    void run();


    boolean equals(Object obj);


    default void test(){
        System.out.println("defaul 方法只能够来实现");
    }
}
