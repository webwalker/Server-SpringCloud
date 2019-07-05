package com.xujian.rocketmq.producer;

import com.xujian.rocketmq.config.RocketMQConfig;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

/**
 * Created by xujian on 2019-07-01
 */
@Component
public class AsyncProducer implements IProducer {
    @Override
    public void send() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(RocketMQConfig.TOPIC_GROUP1);
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(1);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            Message msg = new Message(RocketMQConfig.TOPIC1, //RocketMQConfig.ASYNC_TOPIC
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(100000);
        producer.shutdown();
    }
}
