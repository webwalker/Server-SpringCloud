package com.xujian.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("/error1")
    public String showInfo() {
        try {
            String str = null;
            str.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/error2")
    public String showInfo2() {
        int a = 10 / 0;
        return "index";
    }
}
