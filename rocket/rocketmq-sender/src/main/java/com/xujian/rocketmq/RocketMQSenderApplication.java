package com.xujian.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableRocketMQ
public class RocketMQSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMQSenderApplication.class, args);

        //模板初始化
//        RocketMQProducerTemplate producer = new RocketMQProducerTemplate();
//        producer.setProducerGroup("mq-service-producer");
//        //producer.setTimeOut(1000);
//        producer.setOrderlyMessage(true);
//        producer.setMessageClass(String.class);
//        producer.setNamesrvAddr("127.0.0.1:9876");
    }
}
