package com.xujian.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class SyncConsumer {

    @RabbitListener(queues = "material@user2")
    public String execute(Message message, Channel channel) {
        System.out.println("#######################################");
        return "消费者收到了消息，返回给生产者";
    }
}
