# JVM的一些启动参数
1. -XX:SurvivorRatio=8
```jshelllanguage
enden和survive的比例   当-XX:SurvivorRatio=8的时候8:2
```
2. -XX:NewRatio
```jshelllanguage
新生代(eden+survive*2)和老年代的比值
4表示 新生代和老年代的比例为1:4,即新生代占堆的1/5
```
3. -XX:MaxTenuringThreshold=8
参考文章:
https://www.cnblogs.com/webor2006/p/11031563.html
```jshelllanguage
就是当新生代带进入老年代的时候的回收次数，当等于8的时候，说明对象在新生代需要被回收八次，
当被回收第9次的时候会进入老年代。
```





参考文章：
https://www.cnblogs.com/yueshutong/p/9768298.html
https://blog.csdn.net/bolg_hero/article/details/78189621