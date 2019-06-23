package com.xujian.feign.client;

import com.xujian.feign.config.FeignConfiguration;
import com.xujian.feign.entity.User;
import com.xujian.feign.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xujian on 2019-06-23
 */
@FeignClient(value = "hello-service", url = "${feign.baseUrl}",
        configuration = FeignConfiguration.class,
        fallback = HelloServiceFallback.class)
public interface HelloClientService {

    @GetMapping("/server/hello")
    String hello(@RequestParam("p1") String p1, @RequestParam("p2") String p2);

    @GetMapping("/server/user")
    User user();

    @PostMapping("/server/post")
    String post();
}
