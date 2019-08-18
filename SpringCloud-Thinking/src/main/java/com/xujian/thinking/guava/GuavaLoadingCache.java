package com.xujian.thinking.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * 是Cache的子接口，相比较于Cache，当从LoadingCache中读取一个指定key的记录时，
 * 如果该记录不存在，则LoadingCache可以自动执行加载数据到缓存的操作。LoadingCache接口的定义如下：
 * Created by xujian on 2019-08-16
 */
public class GuavaLoadingCache {
    public static void main(String[] args) throws Exception {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(loader);//在构建时指定自动加载器

        loadingCache.get("key1");
        loadingCache.get("key2");
        loadingCache.get("key3");

        TimeUnit.MILLISECONDS.sleep(31);

        loadingCache.getUnchecked("key1");
        loadingCache.getUnchecked("key2");
        loadingCache.getUnchecked("key3");
    }
}
