package com.xujian.apollo.controller;


import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.xujian.apollo.bean.AnnotatedBean;
import com.xujian.apollo.config.spring.SampleRedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

//如果本地和远程都有相同的配置, 会以本地为准
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    //Java Config方式
    @Autowired
    AnnotatedBean javaConfigBean;

    //ConfigurationProperties方式
    @Autowired
    SampleRedisConfig sampleRedisConfig;

    //@ApolloConfig方式
    @ApolloConfig
    private Config config;

    @GetMapping("hi1")
    public String hi(String name) {
        return "hi " + name + " ,i am from remote config:" + javaConfigBean.getTimeout();
    }

    @RequestMapping("/hi2")
    public String hello2() {
        return sampleRedisConfig.commandTimeout + "--" + sampleRedisConfig.expireSeconds;
    }

    @RequestMapping("/hi3")
    public String hello3() {
        Set<String> propertyNames = config.getPropertyNames();
        propertyNames.forEach(key -> {
            System.err.println(key + "=" + config.getIntProperty(key, 0));
        });
        return propertyNames.toString();
    }
}
