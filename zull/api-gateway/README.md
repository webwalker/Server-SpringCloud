利用之前提到的微服务组件，已经可以建立起一个简单的微服务系统：

* 通过 Spring Cloud Eureka 实现高可用服务注册中心
* 通过 Spring Cloud Ribbon 或 Feign 实现服务间负载均衡的接口调用
* 通过 Spring Cloud Hystrix 实现线程隔离和熔断，防止故障扩散

<!-- more -->

微服务架构中后端服务往往不直接开放给外部程序调用，所以需要一个 API 网关，根据请求的Url 路由到相应的服务。

API 网关负责外部应用到微服务系统之间的**请求路由、负载均衡和校验过滤**等功能的实现。

在 Spring Cloud 体系中，Spring Cloud Zuul 组件提供 API 网关的支持。

Zuul 将自身注册为 Eureka 服务治理下的应用，从 Eureka 中获取服务实例信息，从而维护路由规则和服务实例。

Zuul 提供了一套过滤器机制，通过创建过滤器对校验过滤提供支持，可以使微服务应用更专注于业务逻辑的开发。



## 网关实践

在实现网关服务的功能之前，需要搭建几个用于路由和过滤使用的微服务应用，之后就可以着手网关的构建。

### 1.配置路由规则

Zuul 可以按传统路由方式进行配置，`zuul.routes.<route>.path` 配置匹配规则，`zuul.routes.<route>.url` 配置服务地址，其中 \<route\> 为路由名称，可以任意指定。

传统路由单实例、多实例的配置

传统路由方式进行多服务实例配置时，需关闭负载均衡和 Eureka 的结合，通过配置 Ribbon 的服务列表进行负载均衡。传统配置方式需花费大量时间维护 path 和 url 关系，在与 Eureka 结合后，可通过服务发现机制自动维护映射关系。

```properties
## 面向服务的路由
zuul.routes.hello-service.path=/hello-service/**
zuul.routes.hello-service.service-id=hello-service

## 面向服务路由的简介配置
## zuul.routes.<serviceId>=<path>
zuul.routes.feign-consumer=/feign-consumer/**
```

由于大部分的路由配置规则都会采用服务名作为外部请求的前缀，所以 Spring Cloud Zuul 为 Eureka 中的每一个服务都自动创建一个默认的路由规则，如同上面的面上服务的路由。要排除指定服务的默认规则，需要添加如下配置。

```properties
## 排除指定服务的默认规则
zuul.ignored-services=hello-service,feign-consumer

## 关闭所有服务的默认规则
#zuul.ignored-services=*
```

## 过滤器

Zuul 中的过滤器负责在转发外部请求的过程中对处理过程进行干预，在实际运行时，路由映射和请求转发等步骤都是由不同的过滤器完成。

Spring Cloud Zuul 中的过滤器包含以下 4 个基本特征：

* 过滤类型

> 过滤器所处的生命周期，Zuul 默认定义了 4 种不同生命周期，分别为 pre（请求被路由前调用）、routing（在路由请求时被调用）、post（在 routing 和 error 过滤器之后被调用） 和 error（发生错误时被调用）。

* 执行顺序

> 过滤器执行顺序，数值越小优先级越高

* 执行条件

> 通过返回的 boolean 值判断过滤是否执行

* 具体操作

> 过滤器的具体逻辑

### 生命周期

外部 HTTP 请求到达网关直到返回请求结果的整个生命周期如图：

请求到达网关时首先被 pre 类型的过滤器处理，主要目的是在请求路由前做一些请求校验等前置加工。

完成 pre 阶段后进入 routing 请求转发阶段，将外部请求转发到具体服务实例。

routing 之后进入 post，此阶段过滤器不仅可以获取请求信息，还能获得服务实例返回的信息，做一些加工处理。

error 在上述三个阶段发生异常时出发，最后还是流向 post 类型的过滤器。

### 自定义过滤器

Zuul 允许通过定义过滤器实现对请求的拦截和过滤，实现时只需继承 ZuulFilter 抽象类并实现抽象方法。

定义 AccessFilter 过滤器后重新启动，向 api-gateway 发起请求，请求包含 token 参数时响应正常，不包含 token 参数时返回 error token，响应码 401。

## Ribbon 和 Hystrix 支持

spring-cloud-starter-zuul 包含对 spring-cloud-starter-ribbon 和 spring-cloud-starter-hystrix 模块的依赖，天然拥有线程隔离和断路器的自我保护功能。

注意：传统路由配置时不受到保护，也没有负载均衡能力。只有通过面向服务路由才会有自我保护和负载均衡的功能。

```properties
## 指定路由请求转发的超时时间
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=10000

## 指定路由转发请求创建连接的超时时间
ribbon.ConnectTimeout=250

## 指定路由转发请求处理过程的超时时间
ribbon.ReadTimeout=1000
```

**Zuul 在默认配置下请求异常时不会发起重试，如需开启重试功能，首先需要添加 spring-retry 依赖**。

```xml
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
</dependency>
```

添加依赖后针对重试添加如下配置：

```properties
## 全局重试机制开关
zuul.retryable=true

## 关闭指定路由的重试机制
## zuul.routes.<route>.retryable
zuul.routes.hello-service.retryable=false

## 对当前服务实例的重试次数
ribbon.MaxAutoRetries=2
## 重试切换的实例数
ribbon.MaxAutoRetriesNextServer=0
```



- http://localhost:5555/hello-service/hello?token=123&p1=1&p2=2
- -> http://localhost:8081/hello?token=123&p1=1&p2=2

- http://localhost:5555/feign-consumer/hello?token=123&p1=1&p2=2
- —>
- http://localhost:8083/hello?token=123&p1=1&p2=2