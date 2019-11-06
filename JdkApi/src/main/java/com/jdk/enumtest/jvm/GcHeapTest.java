package com.jdk.enumtest.jvm;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-06
 * JVM配置参数:
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -Xms40M -Xmx40M -Xmn20M
 */
public class GcHeapTest {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 新生代为20M
     * eden:to-sur:from-sur 8:1:1 eden的大小为:16M
     *
     * 所以第二个8M的数组会进入到老年代，当test2()出栈的时候，年轻代会被回收光
     */
    public static void test2(){
        byte[] byte1 = new byte[1024*1024/2];
        byte[] byte2 = new byte[1024*1024*8];
        byte2 = null;
        byte2 = new byte[1024*1024*8];
        System.gc();    //注释此行
    }
}
