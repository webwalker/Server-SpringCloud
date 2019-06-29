#指定所创建镜像的基础镜像，本地没有就会去官方库下载, 可以指定多个
FROM openjdk:8-jdk-alpine
#java:8

#作者信息
MAINTAINER xujian (xujian.sh@qq.com)

#创建一个可以从本地主机或其他容器挂载的挂载点，一般用来存放数据库和需要保持的数据等。
VOLUME /tmp

#复制指定的文件到容器中且重命名
ADD spring-cloud-docker-*.jar app.jar
#COPY

#要执行的命令, 所有的SSH都可以, 可用 \ 换行 和 && 连接符
RUN sh -c 'touch /app.jar'
#RUN mkdir /opt/leh \
#  && touch /opt/leh/test

#指定容器启动时默认执行的命令，每个Dockerfile文件只能有一条CMD命令，Docker 不是虚拟机，容器就是进程。
#既然是进程，那么在启动容器的时候，需要指定所运行的程序及参数。 CMD 指令就是用于指定默认的容器主进程的启动命令的。
#CMD echo "Hello xujian"

#设置环境变量
ENV JAVA_OPTS=""
#指定一些镜像内使用的参数(例如版本号)，在执行docker build命令时以–build-arg< varname>=< value>的格式传入。
#ARG
#配置容器启动时执行的命令，并且不可被 docker run 提供的参数覆盖
ENTRYPOINT ["java","$JAVA_OPTS","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]

#指定工作目录
#WORKDIR

#声明镜像内服务所监听的端口
EXPOSE 8282
