# SpringCloud MQ

#### 环境搭建
**1、rabbitmq**

```
brew install rabbitmq
cd /usr/local/Cellar/rabbitmq/3.7.15
brew services start rabbitmq
brew services restart rabbitmq
brew services stop rabbitmq
./rabbitmq-server
```

**2、docker**

- https://docs.docker.com/compose/ 
- docker-compose up  
   docker-compose.yml  
   image
- 设置用户名和密码
docker run -d --hostname rabbit-host --name rabbitmq -e RABBITMQ_DEFAULT_USER=xujian -e RABBITMQ_DEFAULT_PASS=123456 -p 15672:15672 -p 5672:5672 rabbitmq:management

#### 测试运行
1. 创建exchange、queue

- 通过管理界面或其他工具  
	http://localhost:15672
- 通过应用动态程序

2. 启动RabbitMQ服务
3. 运行主项目，监听消息接收
4. 运行单元测试，发送消息
5. 查看Run Dashboard服务的日志输出




