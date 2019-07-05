官方文档：
https://github.com/apache/rocketmq-spring/blob/master/README_zh_CN.md
非Template格式的发送参考https://github.com/apache/rocketmq示例（Tag过滤器、pullConsumer）。

功能特性：

-  同步发送
-  同步顺序发送
-  同步批量发送
-  异步发送
-  异步顺序发送
-  顺序消费
-  并发消费（广播/集群）
-  one-way方式发送
-  事务方式发送
-  消息轨迹
-  ACL
-  pull消费

- 先创建好消费者组、生产者组
- 主题可以自动创建

在将Spring的Message转化为RocketMQ的Message时，为防止`header`信息与RocketMQ的系统属性冲突，在所有`header`的名称前面都统一添加了前缀`USERS_`。因此在消费时如果想获取自定义的消息头信息，请遍历头信息中以`USERS_`开头的key即可。

SpringBoot示例：https://github.com/apache/rocketmq-spring

原始示例：https://github.com/apache/rocketmq/tree/master/example

扩展工具：https://github.com/apache/rocketmq-externals

Docker：https://github.com/apache/rocketmq-docker