package com.jdk.enumtest;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-09
 */
public enum Day {
    MONDAY("周1"), TUESDAY("周2"), WEDNESDAY("周3"),
    THURSDAY("周4"), FRIDAY("周5"), SATURDAY("周6"), SUNDAY("周日");

    private String desc;

    private Day(String desc){
        this.desc=desc;
    }
    public String getDesc(){
        return desc;
    }
}
