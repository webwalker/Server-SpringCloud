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
public class TimeCostPostFilter extends ZuulFilter {
    private static final String START_TIME_KE = "start_time";
    private Logger logger = LoggerFactory.getLogger(TimeCostPostFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        long startTime = (long) RequestContext.getCurrentContext().get(START_TIME_KE);
        logger.info("请求完成,耗时{}秒", (System.currentTimeMillis() - startTime) / 1000);
        return null;
    }
}