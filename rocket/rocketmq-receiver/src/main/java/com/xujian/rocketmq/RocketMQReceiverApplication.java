package com.xujian.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RocketMQReceiverApplication {

    public static void main(String[] args) {

        SpringApplication.run(RocketMQReceiverApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RocketMQReceiverApplication.class);
//        NormalConsumer normalConsumer = context.getBean(NormalConsumer.class);
//        try {
//            normalConsumer.receive();
//        } catch (MQClientException e) {
//            e.printStackTrace();
//        }
    }
}
