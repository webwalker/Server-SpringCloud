package com.xujian.rocketmq.consumer;

import com.xujian.rocketmq.config.RocketMQConfig;
import com.xujian.rocketmq.entity.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 暂时不要用RocketMQMessageListener, 因为ACK操作不够灵活。
 * Created by xujian on 2019-07-02
 */
@Component
@Slf4j
public class ListenConsumer {
    //同一个Group的只能2选1，否则监听不到
    @Service
    @RocketMQMessageListener(
            //nameServer = "" //可读取配置
            //selectorExpression = "tag1", //过滤消息类型
            topic = RocketMQConfig.TOPIC1, //可读取配置
            consumerGroup = RocketMQConfig.TOPIC_GROUP1)
    public class MyConsumer1 implements RocketMQListener<String> {
        public void onMessage(String message) {
            log.info("----->received message: {}", message);
        }
    }

    //消费原始信息
    @Service
    @RocketMQMessageListener(topic = RocketMQConfig.TOPIC1, consumerGroup = RocketMQConfig.TOPIC_GROUP1)
    public class MyConsumer5 implements RocketMQListener<MessageExt> {
        public void onMessage(MessageExt message) {
            log.info("----->received MessageExt message: {}", message);
        }
    }

    //消费Model消息
    @Service
    @RocketMQMessageListener(topic = RocketMQConfig.TOPIC2, consumerGroup = RocketMQConfig.TOPIC_GROUP2)
    public class MyConsumer2 implements RocketMQListener<OrderPaidEvent> {
        public void onMessage(OrderPaidEvent orderPaidEvent) {
            log.info("----->received orderPaidEvent: {}", orderPaidEvent);
        }
    }

    //消费事务型消息
    @Service
    @RocketMQMessageListener(topic = RocketMQConfig.TOPIC3, consumerGroup = RocketMQConfig.TOPIC_GROUP3,
            accessKey = "",
            secretKey = "")
    public class MyConsumer3 implements RocketMQListener<String> {
        public void onMessage(String message) {
            log.info("----->received transaction message: {}", message);
        }
    }

    //指定消息轨迹
    @Service
    @RocketMQMessageListener(topic = RocketMQConfig.TOPIC4, consumerGroup = RocketMQConfig.TOPIC_GROUP4,
            enableMsgTrace = true, customizedTraceTopic = RocketMQConfig.TOPIC_TRACE)
    public class MyConsumer4 implements RocketMQListener<String> {
        public void onMessage(String message) {
            log.info("----->received trace message: {}", message);
        }
    }

    //自定义消息消费的位置
    @Service
    @RocketMQMessageListener(topic = RocketMQConfig.TOPIC5, consumerGroup = RocketMQConfig.TOPIC_GROUP5)
    public class MyConsumer6 implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {
        @Override
        public void onMessage(String message) {
            log.info("received MyConsumer6 message: {}", message);
        }

        @Override
        public void prepareStart(final DefaultMQPushConsumer consumer) {
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
            consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis()));
        }
    }
}
