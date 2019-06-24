## Feign + 

启动服务注册中心 eureka-server 及服务提供方 hello-service。    

启动 feign-consumer应用，访问 http://localhost:8080/hello?p1=a&p2=b ，feign-consumer 以声明式的服务调用访问 hello-service，返回 `hello, a, b` 。

融合Ribbon、Hystrix：  

见：HelloServiceFallback  

启动服务后断开服务提供方 hello-service，访问 feign-consumer 接口，feign-consumer 会按照 HelloServiceFallback 中的定义执行降级逻辑。

