package com.xujian.helloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 推荐使用@EnableDiscoveryClient代替@EnableEurekaClient注解，因为@EnableDiscoveryClient是一个高度的抽象，
 * 来自于spring-cloud-commons， 由于Spring Cloud选型是中立的因此抽象出该接口，
 * 当服务注册中心选型改变为Eureka，ZK，Consul时，不需要修改原有代码中的注解
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class, args);
    }
}
