package com.jdk.enumtest.sigleton;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-29
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        ContainerSingleton containerSingleton=
//                (ContainerSingleton)ContainerSingleton.getBean("com.jdk.enumtest.sigleton.ContainerSingleton");
//        System.out.println("currenthashmap:"+containerSingleton.getIoc());
//
//
//        ContainerSingleton containerSingleton2=
//                (ContainerSingleton)ContainerSingleton.getBean("com.jdk.enumtest.sigleton.ContainerSingleton");
//
//        System.out.println("currenthashmap:"+containerSingleton2.getIoc());

//        for (int i = 0; i <100 ; i++) {
//            Thread t=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    ContainerSingleton containerSingleton=
//                            null;
//                    try {
//                        containerSingleton = (ContainerSingleton)ContainerSingleton.getBean("com.jdk.enumtest.sigleton.ContainerSingleton");
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InstantiationException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            t.start();
//        }

        Person p1=new Person();
        Person p2=new Person();
        System.out.println(p1.getIoc()==p2.getIoc());
    }
}
