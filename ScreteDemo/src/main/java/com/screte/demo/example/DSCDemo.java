package com.screte.demo.example;

import com.screte.demo.constants.SecreteConstants;
import com.screte.demo.utils.SymmetricEncryptionUtil;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-08
 */
public class DSCDemo {
    public static void main(String[] args) throws Exception {
        String screteWay="DES";
        String str = "测试内容";
        //加密参数长度大于8
        String sign = "123456789";
        byte[] result = SymmetricEncryptionUtil.encrypt(str.getBytes(), sign, screteWay);
        System.out.println("加密后：" + new String(result));
        //直接将如上内容解密
        byte[] decryResult = SymmetricEncryptionUtil.decrypt(result, sign, screteWay);
        System.out.println("解密后：" + new String(decryResult));
    }


}
