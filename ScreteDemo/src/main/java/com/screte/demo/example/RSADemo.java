package com.screte.demo.example;

import com.screte.demo.utils.AsymmetricEncryptionUtil;

import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-08
 * 有些坑:可以参考这个博客
 * https://blog.csdn.net/kzcming/article/details/80019478
 *
 *
 */
public class RSADemo {


    public static void main(String[] args) throws Exception {
        String screateWay="RSA";
        //加密字符串
        String message = "20191008";

        // 公钥私钥的生成一定要用同一个KeyPairGenerator 否则匹配不上
        Map<Integer,String> map=AsymmetricEncryptionUtil.genKeyPair();
        // 公钥加密
        String messageEn = AsymmetricEncryptionUtil.encrypt(message,  map.get(0),screateWay);
        System.out.println("加密后的字符串为:" + messageEn);
        // 私钥进行解密
        String messageDe =AsymmetricEncryptionUtil.decrypt(messageEn,map.get(1),screateWay);
        System.out.println("还原后的字符串为:" + messageDe);
    }




}
