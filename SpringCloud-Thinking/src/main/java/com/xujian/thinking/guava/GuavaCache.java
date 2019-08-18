package com.xujian.thinking.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by xujian on 2019-06-16
 */
public class GuavaCache {
    public static void main(String[] args) throws Exception {
//        maximumSize();
        //expireAfterWrite();
        //expireAfterAccess();
        //weakValues();
        //invalidateAll();
//        RemovalListener();
//        get();
        stats();
    }

    //指定缓存所能够存储的最大记录数量
    public static void maximumSize() throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));
    }

    //指定Cache中存储的对象写入后超过3秒就会过期
    public static void expireAfterWrite() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
    }

    //指定Cache中存储的对象如果超过3秒没有被访问就会过期
    public static void expireAfterAccess() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            Thread.sleep(time * 1000);
            System.out.println("睡眠" + time++ + "秒后取到key1的值为：" + cache.getIfPresent("key1"));
        }
    }

    //通过weakKeys和weakValues方法指定Cache只保存对缓存记录key和value的弱引用。
    // 当没有其他强引用指向key和value时，key和value对象就会被垃圾回收器回收。
    private static void weakValues() {
        Cache<String, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .weakValues()
                .build();
        Object value = new Object();
        cache.put("key1", value);

        value = new Object();//原对象不再有强引用
        System.gc();
        System.out.println(cache.getIfPresent("key1"));
    }

    //invalidateAll或invalidate方法显示删除Cache中的记录
    public static void invalidateAll() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        Object value = new Object();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        List<String> list = new ArrayList<String>();
        list.add("key1");
        list.add("key2");

        cache.invalidateAll(list);//批量清除list中全部key对应的记录
        System.out.println(cache.getIfPresent("key1"));
        System.out.println(cache.getIfPresent("key2"));
        System.out.println(cache.getIfPresent("key3"));
    }

    public static void RemovalListener() throws InterruptedException {
        RemovalListener<String, String> listener = new RemovalListener<String, String>() {
            public void onRemoval(RemovalNotification<String, String> notification) {
                System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
            }
        };
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build();
        Object value = new Object();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        cache.put("key4", "value3");
        cache.put("key5", "value3");
        cache.put("key6", "value3");
        cache.put("key7", "value3");
        cache.put("key8", "value3");
    }

    //统计信息
    //可以对Cache的命中率、加载数据时间等信息进行统计。
    //可以通过CacheBuilder的recordStats方法开启统计信息的开关。开关开启后Cache会自动对缓存的各种操作进行统计，
    // 调用Cache的stats方法可以查看统计后的信息。
    public static void stats() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .recordStats() //开启统计信息开关
                .build();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        cache.put("key4", "value4");

        cache.getIfPresent("key1");
        cache.getIfPresent("key2");
        cache.getIfPresent("key3");
        cache.getIfPresent("key4");
        cache.getIfPresent("key5");
        cache.getIfPresent("key6");

        System.out.println(cache.stats()); //获取统计信息
    }
}
