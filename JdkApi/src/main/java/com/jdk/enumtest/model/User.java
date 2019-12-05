package com.jdk.enumtest.model;

import java.util.Optional;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-04
 */
public class User {
    private String name;
    private String address;
    private String position;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
