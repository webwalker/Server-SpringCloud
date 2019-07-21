package com.xujian.netty.simple.redis;

import com.xujian.netty.simple.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 在Redis中存储protobuf数据
 * Created by xujian on 2019-07-13
 */
public class RedisController {
    @Bean
    public RedisTemplate<String, Object> overrideSerializer(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setEnableTransactionSupport(true);

        StringRedisSerializer keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);

        ProtostuffSerializer valueSerializer = new ProtostuffSerializer();
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashKeySerializer(valueSerializer);
        return redisTemplate;
    }

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/set")
    void ln45() {
        redisTemplate.opsForValue().set("oneCookie", User.builder().id("1").age(20).name("张三").desc("programmer").build());
    }

    @GetMapping("/get")
    User ln51() {
        return (User) redisTemplate.opsForValue().get("oneCookie");
    }
}
