package com.xujian.rocketmq.producer;

import com.xujian.rocketmq.config.RocketMQConfig;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

/**
 * Created by xujian on 2019-07-01
 */
@Component
public class SyncProducer implements IProducer {
    @Override
    public void send() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(RocketMQConfig.TOPIC_GROUP1);
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message(RocketMQConfig.TOPIC1 /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }
}