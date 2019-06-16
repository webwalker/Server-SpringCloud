package com.xujian.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import static com.xujian.rabbitmq.ErrorReceiver.*;

/**
 * 注解的方式完成接收者绑定(队列、交换机、路由)
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = queueName, autoDelete = "false"),
                exchange = @Exchange(value = sender1ExchangeName, type = ExchangeTypes.TOPIC),
                key = routeKey
        )
)
public class ErrorReceiver {
    public static final String queueName = "error.queue";
    public static final String sender1ExchangeName = "error.topic";
    public static final String routeKey = "error.#";

    //接收消息
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Error..........receiver: " + msg);
    }
}
