package com.jdk.enumtest.lamd;

import com.jdk.enumtest.model.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-26
 * 参考博文 https://mp.weixin.qq.com/s/YKvwA6uWVCMrK5A478whng
 */
public class LamdMain {
    /**
     * lamd的如下实现其实只是暂时实现了runnable的run方法，而不用单独写一个实现了
     * 使用这个方法的好处就是随用随实现 而不是用一个类来固定的实现
     * @param args
     */
    public static void main(String[] args) {
        Runnable thread=() -> System.out.println("hello");
        Thread t1=new Thread(thread);
        t1.start();


        /**
         * :: 的使用
         * 1:直接调用static的静态方法
         * 2:可以调用get set方法
         */
        List<String> nams= Arrays.asList("jack","jane");
        nams.forEach(LamdMain::helloLamd);

        List<Person> personList=new ArrayList<>();
        Person p=new Person();
        p.setAge("18");
        p.setName("lingfeng");
        personList.add(p);

        List<String> personName=personList.stream().map(Person::getName).collect(Collectors.toList());

        personName.forEach(person -> System.out.println(person));


        /**
         * 构造器的使用
         */
        // demo-1
        List<String> structureList=Arrays.asList("name-1");
        List<Person> personList1=structureList.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(personList1);

        // demo-2 把list对象通过构造器变成数组
        Person[] personArray=personList1.stream().toArray(Person[]::new);
        for (int i = 0; i < personArray.length; i++) {
            System.out.println(personArray[i]);
        }


        /**
         * 变量作用域
         */

    }

    public static void helloLamd(String message){
        System.out.println("hellLamd:"+message);
    }
}
