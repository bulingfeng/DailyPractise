package com.jdk.enumtest.abstr;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-01
 */
public class AbstractTest {
    public static void main(String[] args) {
        ActionAbstract actionAbstractMan=new ManAction();
        actionAbstractMan.action();

        ActionAbstract actionAbstractWomen=new WomenAction();
        actionAbstractWomen.action();
    }
}
