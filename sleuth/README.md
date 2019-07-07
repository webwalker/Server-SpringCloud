在使用 Spring Boot 2.x 版本后，官方就不推荐自行定制编译了，让我们直接使用编译好的 jar 包.也就是说原来通过@EnableZipkinServer或@EnableZipkinStreamServer的路子，启动SpringBootApplication自建Zipkin Server是不行了

最新的：https://github.com/openzipkin/zipkin#quick-start

新版本不需要在自己搭建zipkin服务，运行官方即可。

docker run -d -p 9411:9411 openzipkin/zipkin

http://localhost:9411/zipkin/

http://localhost:9091/hi

http://localhost:9092/miya

互相调用后，可在zipkin的traces中选择服务名称就可以查询到调用链路。

cd /Library/Services/zipkin

java -jar zipkin.jar

也可以通过**CAT**进行链路追踪。