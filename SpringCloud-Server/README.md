# Server-SpringCloud



# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


通过https://start.spring.io/生成当前项目

###yml
是Spring框架支持的解析格式  
树状结构    
:分隔  
: 赋值
缩进不可以用TAB  

### logback  
虽然基于log4j
功能比log4j更强大，性能比log4j更好

###打包
mvn clean install，打完包在target目录下有对应的jar生成。    
在application.properties配置中指定    spring.profiles.active=dev  

运行：  
运行时动态指定（可覆盖以上的默认配置）  
java -jar target/spring-cloud-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

### Security异常验证
CustomWebSecurityConfig头部注释掉打开即可

### 无界面健康监控
首先放行所有请求  

http://localhost:8888/actuator 查看已暴漏的endpoint  

所有endpoint： https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html
  
暴漏其他的endpoint: management.endpoint.shutdown.enabled=true

### Spring Boot Admin有界面监控和管理

创建Client项目，添加Security、logback.xml、配置发现服务端、配置可发现的信息    

开启了Security权限后，Post心跳到服务端提示403，需要放开验证  
(那么 CSRF 保护默认是开启的，那么在 POST 方式提交表单的时候就必须验证 Token，如果没有，那么自然也就是 403 没权限了)

访问http://localhost:8888启动管理界面    
