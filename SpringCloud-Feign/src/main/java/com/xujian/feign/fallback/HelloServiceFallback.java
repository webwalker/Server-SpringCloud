package com.xujian.feign.fallback;

import com.xujian.feign.client.HelloClientService;
import com.xujian.feign.entity.User;

/**
 * 服务降级
 * Created by xujian on 2019-06-23
 */
public class HelloServiceFallback implements HelloClientService {
    @Override
    public String hello(String p1, String p2) {
        return "error fallback ...";
    }

    @Override
    public User user() {
        return new User("error fallback ...", 0);
    }

    @Override
    public String post() {
        return "error fallback ...";
    }
}
