package com.xujian.zull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    //自定义路由规则, 匹配不到走默认的
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//        return new PatternServiceRouteMapper(
//                "(?<name>^.+)-(?<version>v.+$)",
//                "${version}/${name}");
//    }
}
