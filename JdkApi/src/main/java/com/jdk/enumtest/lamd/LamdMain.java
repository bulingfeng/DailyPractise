package com.jdk.enumtest.lamd;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-26
 * 参考博文 https://mp.weixin.qq.com/s/YKvwA6uWVCMrK5A478whng
 */
public class LamdMain {
    /**
     * lamd的如下实现其实只是暂时实现了runnable的run方法，而不用单独写一个实现了
     * 使用这个方法的好处就是随用随实现 而不是用一个类来固定的实现
     * @param args
     */
    public static void main(String[] args) {
        Runnable thread=() -> System.out.println("hello");
        Thread t1=new Thread(thread);
        t1.start();
    }
}
