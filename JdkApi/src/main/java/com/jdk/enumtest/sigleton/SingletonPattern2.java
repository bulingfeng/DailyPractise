package com.jdk.enumtest.sigleton;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-25
 * 特点：
 * 随着编译器的完成，这个时候就会生产单例对象，并且是线程安全的。
 */
public class SingletonPattern2 {
    private static final SingletonPattern2 s=new SingletonPattern2();


    private SingletonPattern2() {

    }

    public static SingletonPattern2 getInstance(){
        return s;
    }
}
