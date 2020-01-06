package com.jackson.test.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-06
 */
@JsonTypeName("cat")
public class Cat extends Animal{
    boolean likesCream;
    public int lives;
}
