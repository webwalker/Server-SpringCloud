参考：[http://usherblog.site/2018/05/09/Docker部署Spring-Boot应用/](http://usherblog.site/2018/05/09/Docker%E9%83%A8%E7%BD%B2Spring-Boot%E5%BA%94%E7%94%A8/)

构建完成之后，source目录变掉了, 需要手动在设置中修改

- 打包

```
mvn clean package
java -jar target/spring-cloud-docker-0.0.1-SNAPSHOT.jar
```

- 构建镜像

  构建之前需要把**本地代理**关闭。

```
mvn package docker:build
如果报错则使用：mvn package -Dmaven.test.skip=true docker:build
docker images
```

- 运行镜像

  docker run -p 8080:8080 -t springboot/spring-cloud-docker

- 查看运行

  docker ps

- 访问

  http://10.211.55.4:8080/hello

- 保存镜像
  - 导出的路径需要小写字母
  - docker save springboot/spring-cloud-docker -o /users/xujian/downloads/docker.tar
  
- 发布到远程

  - rsync -avzc /Users/xujian/Downloads/docker.tar 10.211.55.4:/data/apps/

- 载入镜像

  - docker load --input docker.tar

- 删除镜像

  - docker rmi -f **image_id**

- 打包日志

```
[INFO] Building image springboot/spring-cloud-docker
Step 1/6 : FROM openjdk:8-jdk-alpine

 ---> a3562aa0b991
Step 2/6 : VOLUME /tmp

 ---> Using cache
 ---> 0ff4b3d5aacd
Step 3/6 : ADD spring-cloud-docker-0.0.1-SNAPSHOT.jar app.jar

 ---> 09b6dfc1ec16
Step 4/6 : RUN sh -c 'touch /app.jar'

 ---> Running in 771db169e035
Removing intermediate container 771db169e035
 ---> d79296420ac4
Step 5/6 : ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

 ---> Running in 9e0429bc727b
Removing intermediate container 9e0429bc727b
 ---> 36fd6a9eacb0
Step 6/6 : EXPOSE 8282

 ---> Running in 0cabede8d41e
Removing intermediate container 0cabede8d41e
 ---> 1b865915116f
ProgressMessage{id=null, status=null, stream=null, error=null, progress=null, progressDetail=null}
Successfully built 1b865915116f
Successfully tagged springboot/spring-cloud-docker:latest
[INFO] Built springboot/spring-cloud-docker
```

