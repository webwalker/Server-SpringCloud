package com.xujian.controller;

import com.xujian.pojo.Greeting;
import com.xujian.pojo.TestEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */
@RestController
public class HelloController {
    @Autowired
    private TestEnv env;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> showHelloWorld() {
        System.out.println("hello......ssss");
        Map<String, Object> map = new HashMap();
        map.put("msg", "Hello World.");
        return map;
    }

    @RequestMapping("/env")
    public String testEnv() {
        return env.getName();
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
