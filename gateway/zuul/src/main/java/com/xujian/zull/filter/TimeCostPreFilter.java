package com.xujian.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Created by xujian on 2019-07-06
 */
public class TimeCostPreFilter extends ZuulFilter {
    public static final String START_TIME_KEY = "start_time";
    private Logger logger = LoggerFactory.getLogger(TimeCostPreFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断是否要拦截的逻辑
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        long startTime = System.currentTimeMillis();
        RequestContext.getCurrentContext().set(START_TIME_KEY, startTime);
        return null;
    }
}