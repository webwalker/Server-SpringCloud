package com.xujian.rabbitmq;

import com.rabbitmq.client.Channel;
import com.xujian.rabbitmq.pojo.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static com.xujian.rabbitmq.RabbitMQConfig.sender1QueueName;
import static com.xujian.rabbitmq.RabbitMQConfig.sender2QueueName;
import static com.xujian.rabbitmq.RabbitMQConfig.sender3QueueName;

@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    //自定义接收
    public void receiveMessage(String message) {
        System.out.println("Sender1-Received <" + message + ">");
        //latch.countDown();
    }

    @RabbitListener(queues = sender1QueueName)
    public void process1(Message message, Channel channel) throws IOException {
        //消息消费有些问题, 总有1条是unack的, 而且发送端setConfirmCallback都是ack失败的
//        //进行参数设置：单条消息的大小限制，一次最多能处理多少条消息，是否将上面设置应用于channel
//        channel.basicQos(0, 1, false);
//        //限流：autoAck设置为false, 自动应答处理
//        channel.basicConsume(sender1QueueName, false, new MyConsumer(channel));

        // 采用手动应答模式, 手动确认应答更为安全稳定
        //multiple 是否要将这个消息以及它之前的消息都确认
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        System.out.println("process1-Received <" + new String(message.getBody()) + ">");
    }

    @RabbitListener(queues = sender2QueueName)
    public void process2(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("process2-Received <" + new String(message.getBody()) + ">");
    }

    @RabbitListener(queues = sender3QueueName)
    public void process3(User user) throws IOException {
        System.out.println("process3-Received <" + user.getName() + user.getPass() + ">");
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
