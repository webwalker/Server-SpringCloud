package com.xujian.rabbitmq;

import com.xujian.rabbitmq.pojo.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

import static com.xujian.rabbitmq.RabbitMQConfig.*;

@Component
public class Sender {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendTopic1() throws InterruptedException {
        System.out.println("Sender1 Sending message...");

        //这里的消息可以是实体类对象 User user = new User();
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("desc", "Sender1 信息描述..");
        messageProperties.getHeaders().put("type", "Sender1 自定义消息类型..");
        //设置消息的过期时间
        //messageProperties.setExpiration("60000");

        String msgId = UUID.randomUUID().toString();
        String msgContent = "Hello RabbitMQ";
        CorrelationData correlationData = new CorrelationData(msgId);
        Message message = MessageBuilder.withBody(msgContent.getBytes())
                .andProperties(messageProperties)
                //.setDeliveryMode(MessageDeliveryMode.PERSISTENT) //默认已经是
                .setContentType("application/json")
                .setCorrelationId(msgId)
                .setMessageId(msgId) //方便消息去重
                .build();
        rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName, sender1key, message, correlationData);
    }

    public void sendTopic2() {
        for (int i = 0; i < 1; i++) {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            String msg = "hello, 序号: " + i;
            rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName, sender2key, msg, correlationData);
        }
    }

    //消费端获取到字符串之后, 反序列化即可
    public void sendDirect() {
        for (int i = 0; i < 1; i++) {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            User user = new User();
            user.setId(i);
            user.setName("xujian1");
            user.setPass("123456");
            rabbitTemplate.convertAndSend(RabbitMQConfig.directExchangeName, sender3key, user, correlationData);
        }
    }
}
