# GC
1. 查看java进程的启动参数

方法1：

```shell
jcmd pid VM.flags 
```
方法2：
```shell
jinfo -flags pid
```
参考的文档：
https://www.cnblogs.com/harbin1900/p/8591978.html
https://www.cnblogs.com/yueshutong/p/9768298.html