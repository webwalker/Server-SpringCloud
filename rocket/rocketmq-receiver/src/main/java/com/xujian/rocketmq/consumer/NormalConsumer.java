package com.xujian.rocketmq.consumer;

import com.xujian.rocketmq.config.RocketMQConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by xujian on 2019-07-01
 */
@Component
public class NormalConsumer implements IConsumer {
    @Override
    public void receive() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(RocketMQConfig.TOPIC_GROUP1);
        consumer.setNamesrvAddr("localhost:9876");

        //设置 Consumer 第一次启动时从队列头部开始消费还是队列尾部开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe(RocketMQConfig.TOPIC1, "*");
        consumer.subscribe(RocketMQConfig.TOPIC2, "*");
        //顺序消息：MessageListenerOrderly
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            try {
                //System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                //默认 list 里只有一条消息，可以通过设置参数来批量接收消息
                if (msgs != null) {
                    for (MessageExt ext : msgs) {
                        try {
                            //ext.getProperty()也可有获得
                            if (ext.getReconsumeTimes() == 3) {
                                //可以将对应的数据保存到数据库，以便人工干预
                                System.out.println(ext.getMsgId() + "," + ext.getBody());
                                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                            }

                            System.out.println("single msg: " + new Date() + " " + new String(ext.getBody(), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}