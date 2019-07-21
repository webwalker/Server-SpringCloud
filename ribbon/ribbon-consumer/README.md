## Ribbon



Ribbon 在单独使用时，可以通过在客户端中配置 ribbonServerList 来指定服务实例列表，通过轮训访问的方式起到负载均衡的作用。

但是在与 Eureka 联合使用时，ribbonServerList 会被重写，改为通过 Eureka 服务注册中心获取服务实例列表，可以通过简单的几行配置完成 Spring Cloud 中服务调用的负载均衡。

- 启动服务注册中心 eureka-server  

- 启动服务提供方 hello-service （启动两个实例）

- 启动服务消费放 hystrix-consumer

多次访问 http://localhost:8080/hello ，可以观察到 ribbon-consumer 通过负载均衡的 restTemplate 轮训地向两个 hello-service 发起请求。  

http://localhost:8085/user?id=1&name=xujian

http://localhost:8085/post-user 

