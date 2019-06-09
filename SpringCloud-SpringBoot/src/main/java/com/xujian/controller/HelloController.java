package com.xujian.controller;

import com.xujian.pojo.TestEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@RestController
public class HelloController {
    @Autowired
    private TestEnv env;

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
}
