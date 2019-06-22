package com.xujian.redis;

import com.xujian.redis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Spring Data Redis测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisApplication.class)
@Slf4j
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 添加一个字符串
     */
    @Test
    public void testSet() {
        this.redisTemplate.opsForValue().set("key", "this is a test.");
    }

    /**
     * 获取一个字符串
     */
    @Test
    public void testGet() {
        String value = (String) this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }

    /**
     * 添加Users对象
     */
    @Test
    public void testSetUesrs() {
        User user = new User();
        user.setAge(25);
        user.setName("张三丰");
        user.setId(1);
        user.setEmail("1@1.com");
        user.setPassword("xxxxxx");
        //重新设置序列化器
        this.redisTemplate.opsForValue().set("user", user);
    }

    /**
     * 取Users对象
     */
    @Test
    public void testGetUsers() {
        //重新设置序列化器
        User user = (User) this.redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

    /**
     * 基于JSON格式存Users对象
     */
    @Test
    public void testSetUsersUseJSON() {
        User user = new User();
        user.setAge(20);
        user.setName("李四丰");
        user.setId(1);
        this.redisTemplate.opsForValue().set("users_json", user);
    }

    /**
     * 基于JSON格式取Users对象
     */
    @Test
    public void testGetUseJSON() {
        User user = (User) this.redisTemplate.opsForValue().get("users_json");
        System.out.println(user);
    }

    @Test
    public void get() {
        // TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );
        stringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "battcn:user:1";
        redisTemplate.opsForValue().set(key, new User(1, "u1", "pa"));
        // TODO 对应 String（字符串）
        final User user = (User) redisTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - [{}]", user);
    }
}
