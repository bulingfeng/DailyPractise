package com.jdk.enumtest.option;

import com.jdk.enumtest.model.User;

import java.util.Optional;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-04
 * Optional 常用的api
 * 参考博客:https://blog.csdn.net/weixin_30905133/article/details/96832342
 */
public class OptionTest {
    public static void main(String[] args) {
        // 1:map和flatMap
        // 区别 map是按照方法返回的参数比如这个就是Optional<T>
        // flatMap 就是返回的T
        User user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");
        String position = Optional.ofNullable(user)
                .flatMap(u -> u.getPosition()).orElse("default");

        Optional<String> position2 = Optional.ofNullable(user)
                .map(u -> u.getPosition()).orElse(Optional.of("default"));
        System.out.println(position2.get());

        assertEquals(position, user.getPosition().get());


        //test-2
        // ifPresent()来判断对象是否为空
        // orElse和orElseGet
        User user1=new User();
        Optional<User> optionalUser=Optional.ofNullable(user1);
        System.out.println("test-2,isPresent:"+optionalUser.isPresent());



    }

    private static void assertEquals(String a,String b){
        System.out.println("a:"+a+",b:"+b);
        if (a==null || b==null){
            System.out.println("a,b有一个为空{}");
        }
        if (a.equals(b)){
            System.out.println("a,b相等");
        }
    }
}
