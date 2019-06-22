FROM java:8

VOLUME /ROOT

ADD springboot-docker.jar springboot-docker.jar

RUN bash -c 'touch /springboot-docker.jar'

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone

EXPOSE 8282

ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]
