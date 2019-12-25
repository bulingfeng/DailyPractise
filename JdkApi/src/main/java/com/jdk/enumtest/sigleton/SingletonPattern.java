package com.jdk.enumtest.sigleton;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-25
 * 特点：
 * 当调用getInstance的时候才会初始化 SingletonPattern。并且是线程安全的。
 */
public class SingletonPattern {
    public SingletonPattern() {
    }

    private static class SigletonHolder{
        private static final SingletonPattern singletonPattern = new SingletonPattern();
    }

    public static SingletonPattern getInstance(){
        return SigletonHolder.singletonPattern;
    }
}
