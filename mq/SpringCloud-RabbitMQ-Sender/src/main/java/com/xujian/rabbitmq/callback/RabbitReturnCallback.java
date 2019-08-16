package com.xujian.rabbitmq.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by xujian on 2019-06-19
 */
@Slf4j
public class RabbitReturnCallback implements RabbitTemplate.ReturnCallback{

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        String correlationId = message.getMessageProperties().getCorrelationId();
        System.out.println(String.format("消息：{%s} 发送失败, 应答码：{%s} 原因：{%s} 交换机: {%s}  路由键: {%s}", correlationId, replyCode, replyText, exchange, routingKey));

        log.info("消息主体 message : "+message);
        log.info("消息主体 message : "+replyCode);
        log.info("描述："+replyText);
        log.info("消息使用的交换器 exchange : "+exchange);
        log.info("消息使用的路由键 routing : "+routingKey);
    }
}
