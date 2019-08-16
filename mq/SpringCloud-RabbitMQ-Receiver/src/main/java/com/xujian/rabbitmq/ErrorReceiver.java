package com.xujian.rabbitmq;

import com.xujian.rabbitmq.consumer.BaseConsumer;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import static com.xujian.rabbitmq.RabbitMQConfig.*;

/**
 * 注解的方式完成接收者绑定(队列、交换机、路由)
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = errorQueueName, autoDelete = "false"),
                exchange = @Exchange(value = errorExchangeName, type = ExchangeTypes.TOPIC),
                key = errorRouteKey
        )
)
public class ErrorReceiver implements BaseConsumer {
    //接收消息
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Error..........receiver: " + msg);
    }
}
