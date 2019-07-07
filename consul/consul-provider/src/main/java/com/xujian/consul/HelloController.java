package com.xujian.consul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujian on 2019-07-07
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "helle consul";
    }
}
