package com.xujian.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 安全过滤器
 */
@Component
@Slf4j
public class AccessFilter extends ZuulFilter {
    public static final String START_TIME_KEY = "start_time";

    /**
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定义过滤器的执行顺序，越小顺序越靠前
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        long startTime = System.currentTimeMillis();
        RequestContext.getCurrentContext().set(START_TIME_KEY, startTime);

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        String token = request.getParameter("token");
        if (token == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false); //过滤请求，不对其进行路由
            ctx.setResponseBody("error token");
            ctx.setResponseStatusCode(401);
        }
        return null;
    }
}
