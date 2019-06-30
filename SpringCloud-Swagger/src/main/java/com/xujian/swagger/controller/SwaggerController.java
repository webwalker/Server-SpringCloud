package com.xujian.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"springboot-rabbitmq-demo工程,提供restful接口"})
@ApiOperation("新增用户接口")
@RestController
@RequestMapping("/msgSend")
public class SwaggerController {

    @ApiOperation(value = "传入具体待发送消息,发送到指定的exchange", notes = "根据传入的原始消息和发送方式，进行消息发送")
    @PostMapping("/direct")
    public void direct(String sendMessage, boolean async) {
        if (async) {
            System.out.println("async");
        } else {
            System.out.println("sync");
        }
    }
}
