package com.xujian.springcloudmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * CommandLineRunner时，config类中可通过Bean注解来声明运行时，其他的按照极简方式进行。
 */
@Component
public class Sender1 implements CommandLineRunner {
    @Resource(name = RabbitMQConfig.queueName) //注入name="taskQueue"的Queue
    private Queue queue;

    //构造注入
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Sender1(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sender1 Sending message...");

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        messageProperties.getHeaders().put("desc", "Sender1 信息描述..");
        messageProperties.getHeaders().put("type", "Sender1 自定义消息类型..");
        Message message = new Message("Hello RabbitMQ".getBytes(), messageProperties);

        //queue.getName();
        rabbitTemplate.convertAndSend(RabbitMQConfig.sender1ExchangeName, RabbitMQConfig.routingkey, message.toString(), new MessagePostProcessor() {
            @Override  // message 就是上面声明要发送的消息
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().getHeaders().put("desc", "额外修改的信息描述");
                message.getMessageProperties().getHeaders().put("attr", "额外新加的属性");
                return message;
            }
        });
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
