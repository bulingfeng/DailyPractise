package com.jdk.enumtest.sigleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-29
 * 参考资料
 * https://www.jianshu.com/p/bda22c8a516f
 *
 * 个人判断这个是线程安全的
 */
public class ContainerSingleton {
    private ContainerSingleton(){

    }
    private static  Map<String,Object> ioc=new ConcurrentHashMap<String,Object>();
    public static Object getBean(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj=null;
                    obj=Class.forName(className).newInstance();
                    ioc.put(className,obj);
                return obj;
            }else{
                return ioc.get(className);
            }
        }
    }

}
