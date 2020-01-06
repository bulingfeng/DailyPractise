package com.jackson.test.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author:bulingfeng
 * @Date: 2020-01-06
 * 参考文献:
 * https://www.cnblogs.com/windyWu/p/11243188.html
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
})

public class Animal {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Cat cat=new Cat();
        cat.setName("小喵");
        String catString=new ObjectMapper().writeValueAsString(cat);
        System.out.println("cat--->"+catString);
    }
}
