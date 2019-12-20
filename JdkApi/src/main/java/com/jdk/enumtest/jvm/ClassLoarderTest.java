package com.jdk.enumtest.jvm;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-20
 */
public class ClassLoarderTest {
    public static void main(String[] args) {
//        bootstrapClassLoader();
//        extClassLoader();
        applicationClassLoader();
    }


    private static void bootstrapClassLoader(){
        System.out.println("bootstrapClassLoader >>> 开始");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls)
            System.out.println(url);

        System.out.println("bootstrapClassLoader >>> 结束");
        //取得扩展类加载器
        URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();
    }

    private static void extClassLoader(){
        System.out.println("extClassLoader >>> 开始");
        //取得扩展类加载器
        URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();
        URL[] urls = extClassLoader.getURLs();
        for(URL url : urls)
            System.out.println(url);
        System.out.println("extClassLoader >>> 结束");
    }

    private static void applicationClassLoader(){
        System.out.println("applicationClassLoader >>> 开始");
        //取得应用(系统)类加载器
        URLClassLoader appClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        URL[] urls = appClassLoader.getURLs();
        for(URL url : urls)
            System.out.println(url);
        System.out.println("applicationClassLoader >>> 结束");

    }
}
