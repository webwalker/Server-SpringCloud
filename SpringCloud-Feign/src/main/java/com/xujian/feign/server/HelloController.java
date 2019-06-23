package com.xujian.feign.server;

import com.xujian.feign.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujian on 2019-06-23
 */
@RestController
@RequestMapping("/server")
public class HelloController {

    @RequestMapping("hello")
    public String hello(@RequestParam String p1, @RequestParam String p2) {
        System.out.println("hello service get hello");
        return "hello, " + p1 + ", " + p2;
    }

    @RequestMapping("user")
    public User user() {
        System.out.println("hello service get user");
        return new User("Jack", 22);
    }

    @RequestMapping("post")
    public String post() {
        System.out.println("hello service post");
        return "post";
    }
}
