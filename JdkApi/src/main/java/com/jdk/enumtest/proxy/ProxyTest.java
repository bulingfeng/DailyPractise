package com.jdk.enumtest.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-17
 * 动态代理
 * https://www.jianshu.com/p/23d3f1a2b3c7
 * https://juejin.im/post/5ad3e6b36fb9a028ba1fee6a
 * https://juejin.im/post/5ad3e6b36fb9a028ba1fee6a
 */
public class ProxyTest {
    public static void main(String[] args){

        CookManager cookManager = new CookManager();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(cookManager);
        ICook iCook =(ICook) Proxy.newProxyInstance(dynamicProxyHandler.getClass().getClassLoader(),cookManager.getClass().getInterfaces(), dynamicProxyHandler);
        //打印一下代理类的类名
        System.out.println(iCook.getClass().getName());
//        iCook.dealWithFoot();
        iCook.cook();
    }
}
