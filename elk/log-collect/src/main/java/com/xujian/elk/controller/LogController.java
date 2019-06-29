package com.xujian.elk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujian on 2019-06-29
 */
@RestController
public class LogController {
    Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("test")
    public void test() {
        logger.info("测试初始一些日志吧！");
    }

}
