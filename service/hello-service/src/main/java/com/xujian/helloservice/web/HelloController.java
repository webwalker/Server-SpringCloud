package com.xujian.helloservice.web;

import com.xujian.helloapi.dto.User;
import com.xujian.helloapi.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController implements HelloService {

    @Override
    public String hello(@RequestParam String p1, @RequestParam String p2) {
        System.out.println("hello service get hello");
        return "hello-service, " + p1 + ", " + p2;
    }

    @Override
    public String hello1(@RequestParam String p1, @RequestParam String p2) throws InterruptedException {
        int sleepTime = new Random().nextInt(2000);
        System.out.println("hello sleep " + sleepTime);
        Thread.sleep(sleepTime);
        return "hello-service, " + p1 + ", " + p2;
    }

    @Override
    public String post() {
        System.out.println("hello service post");
        sleep();
        return "post";
    }

    private void sleep() {
        try {
            int sleepTime = new Random().nextInt(2000);
            System.out.println("sleep " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User user(@RequestParam int id, @RequestParam java.lang.String name) {
        System.out.println("get user");
        return new User(name, id);
    }

    public String user(@RequestBody User user) {
        System.out.println("post user");
        return user.toString();
    }
}
