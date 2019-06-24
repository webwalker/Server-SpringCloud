package com.xujian.feign.service;

import com.xujian.helloapi.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

//这里的hello-service是远程服务实例的名称, 通过注册中心发现
//找到该实例后会自动调用远程的该服务: http://localhost:8081/hello
@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
public interface RefactorHelloService extends HelloService {
}
