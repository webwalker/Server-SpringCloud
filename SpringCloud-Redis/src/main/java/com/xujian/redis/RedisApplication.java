package com.xujian.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启基于注解的缓存
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    //获取配置中的数据
    @ConfigurationProperties
    private class DataJedisProperties {
        @Value("${spring.redis.host}")
        private String host;
    }
}
