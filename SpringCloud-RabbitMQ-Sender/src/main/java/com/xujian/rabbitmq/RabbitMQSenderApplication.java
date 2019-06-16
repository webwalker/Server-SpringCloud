package com.xujian.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQSenderApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RabbitMQSenderApplication.class, args);
        //SpringApplication.run(RabbitMQApplication.class, args).close();
    }
}
