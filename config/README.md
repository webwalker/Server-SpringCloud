Spring Cloud Config 用于为分布式系统中的基础设施和微服务应用提供集中化的外部配置支持，分为服务端和客户端。

服务端为分布式配置中心，是一个独立的微服务应用；客户端为分布式系统中的基础设置或微服务应用，通过指定配置中心来管理相关的配置。

Spring Cloud Config 构建的配置中心，除了适用于 Spring 构建的应用外，也可以在任何其他语言构建的应用中使用。

Spring Cloud Config 默认采用 Git 存储配置信息，天然支持对配置信息的版本管理。



### 1.创建配置仓库并提交修改

创建 Git 仓库及 config 目录，添加 `ulyssesss.properties`、`ulyssesss-dev.properties`，在配置中分别添加 `from=default-1.0` 和 `from=dev-1.0` 。

创建 `config-label-test` 分支，将配置文件中的版本号 `1.0` 修改为 `2.0` 。

提交修改并推送至远程仓库后启动 config-server，可按照以下规则访问配置信息：

- / {application} / {profile} [ / {label} ]
- / {application} - {profile} . yml
- / {label} / {application} - {profile} . yml
- / {application} - {profile} . properties
- / {label} / {application} - {profile} . properties

2、由于 Spring Boot 应用会优先加载应用 jar 包以外的配置，而通过 bootstrap.yml 对 config-server 的配置会使应用从 config-server 中获取外部配置，优先级比本地配置高。

3、http://localhost:8080/from

得到返回结果 `from=dev-2.0` 。修改配置中的 `spring.cloud.config.profile` 和 `spring.cloud.config.label` ，重启应用再次访问链接会得到相应的配置信息。



## 服务模式高可用配置

传统模式的高可用不需要额外的配置，只需将所有的 config-server 实例全部指向同一个 Git 仓库，客户端指定 config-server 时指向上层负载均衡设备地址。

服务模式通过将 config-server 纳入 Eureka 服务治理体系，将 config-server 注册成为一个微服务应用，客户端通过服务名从服务注册中心获取配置中心的实例信息。



## 动态刷新配置

有时需要对配置内容进行实时更新，Spring Cloud Config 通过 actuator 可实现此功能。

修改配置中 from 的值，提交到远程仓库，通过 post 方法访问 http://localhost:8080/refresh 即可刷新配置项的值。

注意，spring boot 1.5 以上会默认开启安全认证，可通过一下配置关闭安全认证。