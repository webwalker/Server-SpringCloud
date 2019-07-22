package com.xujian.hystrix.web;

import com.xujian.hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @GetMapping("hello")
    public String hello(@RequestParam String p1, @RequestParam String p2) {
        System.out.println("hello");
        return helloService.hello(p1, p2);
    }

    @GetMapping("hello1")
    public String hello1(@RequestParam String p1, @RequestParam String p2) {
        System.out.println("hello1");
        return helloService.hello(p1, p2);
    }

    @GetMapping("/hi")
    public String hi(String name) {
        return helloService.sayHello( name );
    }
}
