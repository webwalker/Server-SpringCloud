## Feign+Hystrix 进行服务调用

启动服务注册中心 eureka-server  

启动服务提供方 hello-service  

启动服务消费放 hystrix-consumer

http://localhost:8080/hello?p1=1&p2=2

正常情况下响应为 `hello, 1, 2` ，关闭 hello-service 或在 sleepTime 超过 1000ms 时，执行降级逻辑，返回 `error, 1, 2` 。