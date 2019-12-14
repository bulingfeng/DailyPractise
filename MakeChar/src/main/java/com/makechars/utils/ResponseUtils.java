package com.makechars.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtils<T> {
    private String code;
    private String message;
    private T data;


    public static <T> ResponseUtils<T> success(T data){
        return new ResponseUtils<T>("200","success",data);
    }


    public static <T> ResponseUtils<T> fail(T data,String message){
        return new ResponseUtils<T>("500",message,data);
    }
}
