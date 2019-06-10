## 高可用服务端集群


在搭建 Eureka 集群时，需要添加多个配置文件，并且使用 SpringBoot 的多环境配置方 式。集群中需要多少节点就添加多少个配置文件。

各个Eureka服务器之间进行通讯，统一对外提供注册中心服务

1、mvn clean install 打包  

2、命令    

java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka1  
java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka2

http://localhost:8763/  
http://localhost:8764/

start_server.sh 编辑其中的JAR_NAME、SPRING_PROFILES_ACTIV  
chmod -R 755 server1.sh  
chmod -R 755 server2.sh    
./server1.sh start  
./server1.sh stop  
./server2.sh start  
./server2.sh stop  

vim /etc/hosts  
192.168.70.134 eureka1  
192.168.70.135 eureka2
