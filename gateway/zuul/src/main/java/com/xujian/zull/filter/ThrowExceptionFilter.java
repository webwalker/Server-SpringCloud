package com.xujian.zull.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by xujian on 2019-07-06
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        //需要在默认的 SendErrorFilter 之前
        return 100; // Needs to run before SendErrorFilter which has filterOrder == 0
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 需要set才可以被SendErrorFilter捕获
     *
     * @return
     */
    @Override
    public Object run() {
        log.info("This is a pre monitor, it will throw a RuntimeException");

        doSomething();

        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }
}
