package com.jackson.test.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-06
 */
@JsonTypeName("dog")
public class Dog extends Animal{
    public double barkVolume;
}
