package com.screte.demo.example;

import org.apache.commons.codec.binary.Base64;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-08
 */
public class Base64Demo {
    public static void main(String[] args) {
        String string = "lingfeng";
        //编码
        String encode = encode(string.getBytes());
        System.out.println("base64加密后:"+encode);
        //解码
        String decode = decode(encode.getBytes());
        System.out.println("base64解密:"+decode);
    }

    //base64 解码
    public static String decode(byte[] bytes) {
        return new String(Base64.decodeBase64(bytes));
    }

    //base64 编码
    public static String encode(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }
}
