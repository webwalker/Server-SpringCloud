package com.xujian.rabbitmq.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msgSend")
public class RabbitMqMessageController {
    @Autowired
    private MessageSender messageSender;

    @PostMapping("/direct")
    public void direct(String sendMessage, boolean async) {
        if (async) {
            messageSender.asyncSend(sendMessage);
        } else {
            messageSender.syncSend(sendMessage);
        }
    }
}
