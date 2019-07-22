package com.xujian.hystrix;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xujian on 2019-07-21
 */
@Configuration
public class HystrixConfig {
    /**
     * 声明一个HystrixCommandAspect代理类，现拦截HystrixCommand的功能
     */
    //@Bean
    public HystrixCommandAspect hystrixCommandAspect() {
        return new HystrixCommandAspect();
    }
}
