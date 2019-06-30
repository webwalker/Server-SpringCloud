package com.xujian.kafka.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by xujian on 2019-06-30
 */
@Component
public class KafkaConsumer {
    private Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    /**
     * 监听seckill主题,有消息就读取
     *
     * @param message
     */
    @KafkaListener(topics = {"seckill"}, groupId = "test")
    public void receiveMessage(String message) {
        //查看日志：日志文件、宿主的运行控制台日志
        System.out.println("-------->KafkaConsumer receive..." + message);
        LOG.info("-------->KafkaConsumer receive..." + message);
    }
}
