参考Gateway部分：https://github.com/forezp/SpringCloudLearning

流量控制：https://github.com/forezp/SpringCloudLearning/tree/master/sc-f-gateway-limiter

因为限流是默认基于Redis的，访问接口测试后，这时候Redis中会有对应的数据：

```
127.0.0.1:6379> keys *
1) "request_rate_limiter.{localhost}.timestamp"
2) "request_rate_limiter.{localhost}.tokens"
```



先注释掉yml中的配置，然后执行测试代码，生成Redis缓存，然后启动项目测试路由。

更新路由：http://localhost:9999/route/update

访问路由：http://localhost:9999/actuator/gateway/routes

调用服务，验证路由映射。

