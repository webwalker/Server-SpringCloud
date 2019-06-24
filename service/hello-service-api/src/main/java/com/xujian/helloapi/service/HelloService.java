package com.xujian.helloapi.service;

import com.xujian.helloapi.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {

    @GetMapping("hello") //这里的"hello"对应的是远程的方法名称
    String hello(@RequestParam("p1") String p1, @RequestParam("p2") String p2);

    @GetMapping("hello1") //这里的"hello1"对应的是远程的方法名称
    String hello1(@RequestParam("p1") String p1, @RequestParam("p2") String p2) throws InterruptedException;

    @GetMapping("user")
    User user(@RequestParam int id, @RequestParam java.lang.String name);

    @PostMapping("user")
    String user(@RequestBody User user);

    @PostMapping("post")
    String post();
}
