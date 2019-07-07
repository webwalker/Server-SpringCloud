package com.xujian.zull.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xujian.zull.entity.ErrorItem;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujian on 2019-07-06
 */
@RestController
public class MainController implements ErrorController {
    /**
     * 出异常后进入该方法，交由下面的方法处理
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public Object error() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException) ctx.getThrowable();
        return new ErrorItem(exception.nStatusCode, exception.getMessage());
    }
}