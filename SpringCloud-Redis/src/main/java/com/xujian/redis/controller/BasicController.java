package com.xujian.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xujian on 2019-06-19
 */
@RestController
public class BasicController {
    //value是必需的，设定存放的命名空间, key是spEL表达式：key = "targetClass + methodName +#p0"
    @Cacheable(value = "emp")
    public List<String> queryAll() {
        return null;
    }

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/setValue")
    public String setValue() {
        if (!template.hasKey("shabao")) {
            template.opsForValue().append("test", "我是test");
            return "使用redis缓存保存数据成功";
        } else {
            template.delete("shabao");
            return "key已存在";
        }
    }

    @RequestMapping("/getValue")
    public String getValue() {
        if (!template.hasKey("test")) {
            return "key不存在，请先保存数据";
        } else {
            String shabao = template.opsForValue().get("test");//根据key获取缓存中的val
            return "获取到缓存中的数据：test=" + shabao;
        }
    }
}
