## Netty Client

如果项目中有依赖冲突，执行protobuf/compile时不会提示，也不会生成GreeterGrpc.java

注意：target目录下生成的文件，可以直接用来编译，不需要在拷贝到主项目中。  

1. Springboot 整合 Netty：https://github.com/pjmike/springboot-netty

- 构建Netty 服务端
- 构建Netty 客户端
- 利用protobuf定义消息格式
- 服务端空闲检测
- 客户端发送心跳包与断线重连

2. Spring Boot内置Servlet容器  
	https://github.com/Leibnizhu/spring-boot-starter-netty
3. WebSocket聊天室  
  https://github.com/UncleCatMySelf/InChat 
4. 三分钟构建高性能 WebSocket 服务  
	https://github.com/YeautyYE/netty-websocket-spring-boot-starter
5. Netty实践学习案例
	https://github.com/sanshengshui/netty-learning-example
