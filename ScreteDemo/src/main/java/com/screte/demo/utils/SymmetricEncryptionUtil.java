package com.screte.demo.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * 对称加密的工具类
 * 算法有 DSC AES 3DSC
 *
 * AES
 * @Author:bulingfeng
 * @Date: 2019-10-08
 */
public class SymmetricEncryptionUtil {

    /**
     *
     * @param datasource
     * @param sign 加密参数
     * @param screteWay 加密的方式
     * @return
     */
    public static byte[] encrypt(byte[] datasource, String sign,String screteWay) throws Exception {

            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(sign.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(screteWay);
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(screteWay);
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            // 这里加不加这个random意义不大 也一样能加密和解密成功
//            cipher.init(Cipher.ENCRYPT_MODE, securekey,random);

            //正式执行加密操作
            return cipher.doFinal(datasource);
    }

    /**
     *
     * @param src 需要解密的数组
     * @param sign 解密参数
     * @param screteWay  解密的方式
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String sign,String screteWay) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(sign.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(screteWay);
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(screteWay);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey);
        // 解密的时候这个random参数可有可无
//        cipher.init(Cipher.DECRYPT_MODE, securekey,random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }




}
