package com.xujian.feign.client;

import com.xujian.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xujian on 2019-06-23
 */
@RestController
public class HelloClientController {
    @Autowired
    HelloClientService helloClientService;

    //http://localhost:8080/testHello?p1=a&p2=b
    @GetMapping("testHello")
    public String hello(@RequestParam String p1, @RequestParam String p2) {
        System.out.println("feign consumer get hello");
        return helloClientService.hello(p1, p2);
    }

    @GetMapping("testUser")
    public User user() {
        System.out.println("feign consumer get user");
        return helloClientService.user();
    }

    @PostMapping("testPost")
    public String post() {
        System.out.println("feign consumer post");
        return helloClientService.post();
    }
}
