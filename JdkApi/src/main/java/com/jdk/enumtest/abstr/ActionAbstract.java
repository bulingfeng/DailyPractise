package com.jdk.enumtest.abstr;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-01
 */
public abstract class ActionAbstract {

    // 做某些事情的抽象方法
    protected abstract void doSomeThings();


    public void action(){
        doSomeThings();
    }
}
