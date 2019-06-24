package com.xujian.feign.service;

import com.xujian.helloapi.dto.User;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements RefactorHelloService {

    @Override
    public String hello(String p1, String p2) {
        return "error";
    }

    @Override
    public String hello1(String p1, String p2) throws InterruptedException {
        return "error";
    }

    @Override
    public User user(int id, String name) {
        return new User("error", 0);
    }

    @Override
    public String user(User user) {
        return null;
    }

    @Override
    public String post() {
        return "error";
    }
}
