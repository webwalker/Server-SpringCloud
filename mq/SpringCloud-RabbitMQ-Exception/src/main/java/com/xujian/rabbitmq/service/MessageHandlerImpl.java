package com.xujian.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("messageHandler")
@Slf4j
public class MessageHandlerImpl implements MessageHandler {

    @Override
    public void HandlerMessage(Message message, String type) {
        if ("user".equals(type)) {
            log.info("66666用户服务消费消息:" + new String(message.getBody()) + ";该消息的id："
                    + message.getMessageProperties().getCorrelationId());
        } else {
            log.info("77777供需关系服务消费消息:" + new String(message.getBody()) + ";该消息的id："
                    + message.getMessageProperties().getCorrelationId());
        }
    }

}
