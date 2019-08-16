package com.xujian.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 初始化创建队列、转发器，并把队列绑定到转发器
 */
@SpringBootApplication
public class RabbitMQReceiverApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RabbitMQReceiverApplication.class, args);
        //SpringApplication.run(RabbitMQApplication.class, args).close();
    }
}
