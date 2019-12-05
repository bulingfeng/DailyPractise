### 参考资料
某个哥们博客写的很不错有各种解释和demo
https://www.jianshu.com/p/1fa12b92d5c4
官方的介绍 例子不多
https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/html/spring-boot-features.html#boot-features-logging

### 日志格式的说明
```jshelllanguage
%d{pattern}日期
%m或者%msg为信息
%M为method
%L为行号
%thread线程名称
%n换行
%-5level

%C{length} |  %class{length}

%c {length }  |  %lo {length }   |  %logger {length }
输出日志的logger名，可有一个整形参数，功能是缩短logger名，设置为0表示只输入logger最右边点符号之后的字符串
例如:%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %C{36} %M %L - %msg %m %n
```
