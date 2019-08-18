package com.xujian.thinking.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xujian on 2019-08-16
 */
@Slf4j
public class GuavaRefreshCache {
    public static void main(String[] args) throws Exception {
        AtomicInteger counter = new AtomicInteger(0);
        CacheLoader<String, Long> cacheLoader = CacheLoader
                .from(k -> {
                    counter.incrementAndGet();
                    log.info("创建 key :" + k);
                    return System.currentTimeMillis();
                });
        LoadingCache<String, Long> cache = CacheBuilder.newBuilder()
                .refreshAfterWrite(2, TimeUnit.SECONDS) // 2s后重新刷新
                .build(cacheLoader);

        Long result1 = cache.getUnchecked("guava");
        TimeUnit.SECONDS.sleep(3);
        Long result2 = cache.getUnchecked("guava");
        log.info(result1.longValue() != result2.longValue() ? "已刷新" : "未刷新");
    }
}
