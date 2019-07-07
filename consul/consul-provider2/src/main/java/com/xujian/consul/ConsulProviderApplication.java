package com.xujian.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by xujian on 2019-06-24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication.class);
    }
}
