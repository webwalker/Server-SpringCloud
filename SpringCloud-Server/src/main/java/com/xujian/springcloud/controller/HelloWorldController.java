package com.xujian.springcloud.controller;

import com.xujian.springcloud.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${msg}")
//	@Value("${hello.msg2}")
    private String msg;

    @RequestMapping("/hello")
    public String showMsg() {
        return this.msg;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.POST)
    public String showMsg1() {
        return this.msg;
    }

    @RequestMapping("/testError")
    public String error() {
        int a = 1 / 0;
        return this.msg;
    }

    @RequestMapping("/testError2")
    public String error2() {
        String str = null;
        str.length();
        return this.msg;
    }

    @RequestMapping("/testError3")
    public String error3() {
        throw new ApplicationException("自定义出错了.");
    }
}
