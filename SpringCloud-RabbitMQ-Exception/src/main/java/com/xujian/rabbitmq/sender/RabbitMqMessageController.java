package com.xujian.rabbitmq.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"springboot-rabbitmq-demo工程,提供restful接口"})
@RestController
@RequestMapping("/msgSend")
public class RabbitMqMessageController {

  @Autowired
  private MessageSender messageSender;

  @ApiOperation(value = "传入具体待发送消息,发送到指定的exchange", notes = "根据传入的原始消息和发送方式，进行消息发送")
  @PostMapping("/direct")
  public void direct(String sendMessage,boolean async) {
    if (async) {
      messageSender.asyncSend(sendMessage);
    } else {
      messageSender.syncSend(sendMessage);
    }
  }
}
