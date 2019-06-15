package com.xujian.springcloudmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Sender1-Received <" + message + ">");
//        latch.countDown();
    }

    //接收消息的方法。采用消息队列监听机制
    @RabbitListener(queues = RabbitMQConfig.queueName)
    public void process(String message) {
        System.out.println("Sender2-Received <" + message + ">");
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
