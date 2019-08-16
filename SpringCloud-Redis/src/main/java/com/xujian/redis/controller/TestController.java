package com.xujian.redis.controller;

import com.xujian.redis.pojo.User;
import com.xujian.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xujian on 2019-08-08
 */
@RestController
public class TestController {
    @Autowired
    private RedisUtil redis;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //简短、可读
    private String PAY_KEY1 = "order:pay:id";
    private String PAY_KEY2 = "order:pay:id";
    private String PAY_KEY3 = "order:pay:id";
    private String PAY_KEY4 = "order:pay:id";

    @RequestMapping("/test")
    public String test() {
        //----------hash
        //相当于一行数据, 多列多个值
        redis.hset("hashValue", "map1", "map1-1");
        redis.hset("hashValue", "map1", "map1111-111");
        redis.hset("hashValue", "map2", "map2-2");
        redis.hset("hashValue", "map3", "map3-3");
        redis.hset("hashValue", "map4", new User(1, "a", "b"));

        log(redis.hget("hashValue", "map1"));
        log(redis.hgetList("hashValue"));
        log(redis.hmget("hashValue"));

        //批量写入
        redis.del("hashValue");
        Map<String, Object> maps = new HashMap<>();
        maps.put("map1", "map1-1");
        maps.put("map2", "map2-2");
        maps.put("map3", "map3-3");
        redis.hmset("hashValue", maps);
        log(redis.hmget("hashValue"));
        log(redis.hsget("hashValue"));

        if (redis.hHasKey("hashValue", "map1")) {
            redis.hdel("hashValue", "map1");
        }
        log(redis.hmget("hashValue"));

        List<Object> mapList = new ArrayList<>();
        mapList.add("map1");
        mapList.add("map2");
        mapList.add("map3");
        log(redis.hGetList("hashValue", mapList));

        //hash scan
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan("hashValue", ScanOptions.scanOptions().match("map2").build());
//        Cursor<Map.Entry<Object,Object>> cursor = redisTemplate.opsForHash().scan("hashValue",ScanOptions.NONE);
        while (cursor.hasNext()) {
            Map.Entry<Object, Object> entry = cursor.next();
            System.out.println("通过scan(H key, ScanOptions options)方法获取匹配键值对:" + entry.getKey() + "---->" + entry.getValue());
        }

        //---------set
        redis.sSet("setValue", "map1", "map2", "map3");
        log("set: " + redis.sHasKey("setValue", "map1"));
        log(redis.sGet("setValue"));
        log(redis.sGetSetSize("setValue"));
        redis.sRemove("setValue", "map1");
        log(redis.sGet("setValue"));

        //scan
        //redisTemplate.opsForSet().scan()

        //--------list
        List list = new ArrayList();
        list.add("list1");
        list.add("list1");
        list.add("list2");
        list.add("list3");
        redis.lSet("listValue", list);
        redis.lRemove("listValue", 2, "list1");
        log(redis.lGet("listValue", 0, redis.lGetListSize("listValue") + 10));

        //如果变量值存在，在变量中可以添加不存在的的键值对，如果变量不存在，则新增一个变量，同时将键值对添加到该变量。
        //redisTemplate.opsForHash().putIfAbsent("hashValue","map6","map6-6");

        return "";
    }

    private void log(Object msg) {
        System.out.println("---> " + msg);
    }
}
