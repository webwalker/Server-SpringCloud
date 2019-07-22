package com.xujian.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xujian.hystrix.exception.NotFallbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static String HELLO_SERVICE = "http://hello-service/";

    @HystrixCommand(fallbackMethod = "helloError", //处理降级逻辑的方法
            ignoreExceptions = {NotFallbackException.class}, //指定不执行降级逻辑的异常
            groupKey = "hello", //作为命令统计的分组
            commandKey = "str", //作为命令统计的命令名称
            threadPoolKey = "helloStr") //用于指定线程池的划分
    public String hello(String p1, String p2) {
        System.out.println("discover url: " + HELLO_SERVICE);
        //不带参数
//        return restTemplate.getForObject(HELLO_SERVICE + "hello1?p1=1&p2=2", String.class);
        //带参数
//        return restTemplate.getForObject(HELLO_SERVICE + "hello1?p1={?}&p2={?}", String.class, p1, p2);
        //带map
//        Map<String, Object> params = new HashMap<>();
//        params.put("p1", p1);
//        params.put("p2", p2);
//        return restTemplate.getForObject(HELLO_SERVICE + "hello1?p1={p1}&p2={p2}", String.class, params);
        // 使用方法三，URI访问
        URI uri = URI.create(HELLO_SERVICE + "hello1?p1=1&p2=2");
        return restTemplate.getForObject(uri, String.class);
    }

    @HystrixCommand(fallbackMethod = "helloError",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2")},
            threadPoolProperties = { //参见HystrixThreadPoolProperties类定义
                    @HystrixProperty(name = "coreSize", value = "5"),
//                    @HystrixProperty(name = "maximumSize", value = "5"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public String sayHello(String name) {
        try {
            Thread.sleep(15000);
            return "Hello " + name + " !";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String helloError(String name) {
        return "服务器繁忙，请稍后访问~";
    }

    private String helloError(String p1, String p2, Throwable e) {
        System.out.println("helloFallback class: " + e.getClass());
        return "Hystrix makes error, " + p1 + ", " + p2;
    }

    // discoveryClient获取服务列表中，应用名为hello-service一个服务注册信息
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient
                .getInstances("hello-service");
        if (list != null && list.size() > 0) {
            return String.valueOf(list.get(0).getUri());
        }
        return null;
    }
}
