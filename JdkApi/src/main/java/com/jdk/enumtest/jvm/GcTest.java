package com.jdk.enumtest.jvm;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-06
 * 参考博文:
 *1:jvm讲述
 * https://www.cnblogs.com/yueshutong/p/9768298.html
 *
 */
public class GcTest {
    // 打开gc的调用日志 -XX:+PrintGC
    public static void main(String[] args) {
        test();
    }

    /**
     * [GC (System.gc())  7741K->504K(251392K), 0.0016415 secs]
     * [Full GC (System.gc())  504K->370K(251392K), 0.0043746 secs]
     * gc over
     */
    public static void test(){
        {
            byte[] b = new byte[1024 * 1024 * 5]; // 5MB
            b = null;
        }
        System.gc();
        System.out.println("gc over");
    }
}
