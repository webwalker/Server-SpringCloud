package com.xujian.rabbitmq.service;

import org.springframework.amqp.core.Message;

public interface MessageHandler {

    void HandlerMessage(Message message, String type);
}
