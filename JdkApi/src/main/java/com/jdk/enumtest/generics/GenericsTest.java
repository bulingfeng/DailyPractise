package com.jdk.enumtest.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-28
 */
public class GenericsTest {
    public static void main(String[] args) {
        List<Animal> animalList=new ArrayList<>();

        Cat cat=new Cat();
        cat.setAge("12");

        Dog dog=new Dog();
        dog.setAge("13");

        animalList.add(cat);
        animalList.add(dog);

//        testVoice(animalList);
        testVoice2(animalList);


    }




    public static void testVoice(List<? extends Animal> list){
        for (Animal animal : list) {
            animal.voice();
        }
    }

    public static void testVoice2(List<Animal> list){
        for (Animal animal : list) {
            animal.voice();
        }
    }
}
