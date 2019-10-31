package com.jdk.enumtest.lamd;

import com.jdk.enumtest.model.Person;
import com.sun.istack.internal.NotNull;

import java.awt.event.ActionListener;
import java.util.Timer;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-30
 */
public class LamdWarning {
    public static void main(String[] args) {
    }

    public static void repeat(String text,int count){
        for (int i = 0; i <10 ; i++) {
            ActionListener listener=e -> {
                // lamd表达式中只能指定不变的值 此时的i是变化的所以不能用lamd
//                System.out.println(i+":"+text);
            };
        }
    }
}
