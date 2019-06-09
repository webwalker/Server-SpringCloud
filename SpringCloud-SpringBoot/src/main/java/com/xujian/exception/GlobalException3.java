package com.xujian.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过实现HandlerExceptionResolver接口做全局异常处理
 */
@Configuration
public class GlobalException3 implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同视图跳转
        if (ex instanceof ArithmeticException) {
            mv.setViewName("error1");
        }

        if (ex instanceof NullPointerException) {
            mv.setViewName("error2");
        }
        mv.addObject("error", ex.toString());

        return mv;
    }
}
