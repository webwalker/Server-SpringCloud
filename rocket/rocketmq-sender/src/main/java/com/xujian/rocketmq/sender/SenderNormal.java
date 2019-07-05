package com.xujian.rocketmq.sender;

import com.xujian.rocketmq.config.RocketMQConfig;
import com.xujian.rocketmq.entity.OrderPaidEvent;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 最佳实践：一个应用尽可能用一个Topic, 1个Topic对应一个Group, 不同的用tag来区分
 * <p>
 * Created by xujian on 2019-07-01
 */
@Component
public class SenderNormal {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    //自定义template
    @Resource(name = "extRocketMQTemplate") // 这里必须定义name属性来指向上具体的Spring Bean.
    private RocketMQTemplate extRocketMQTemplate;

    public void sendString() {

        //不同的tag代表不同类型的消息
        String tagName1 = "tag1";
        String destination1 = RocketMQConfig.TOPIC1 + ":" + tagName1;

        //队列选择器，选择投放到哪个队列中，消费端也需要处理
        //SelectMessageQueueByHash, SelectMessageQueueByRandoom, 自定义
//        rocketMQTemplate.setMessageQueueSelector(new MessageQueueSelector() {
//            @Override
//            public MessageQueue select(List<MessageQueue> mqs, org.apache.rocketmq.common.message.Message msg, Object arg) {
//                Integer id = (Integer) arg;
//                int index = id % mqs.size();
//                return mqs.get(index);
//            }
//        });

        rocketMQTemplate.convertAndSend(destination1, "Hello, World!");

        String tagName2 = "tag2";
        String destination2 = RocketMQConfig.TOPIC1 + ":" + tagName2;

        Message<?> message = MessageBuilder
                .withPayload("Hello, World! I'm from normal message")
                //还可以设置其他的所有原生Message的属性信息
                //http://blog.soliloquize.org/2018/08/12/RocketMQ-Message%E7%BB%93%E6%9E%84%E7%9A%84%E5%AE%9A%E4%B9%89/
                .setHeader(MessageConst.PROPERTY_KEYS, "自定义头")
                .build();
        rocketMQTemplate.send(destination2, message);

        //通过自定义模板发送消息
//        String tagName3 = "tag3";
//        String destination3 = RocketMQConfig.TOPIC1 + ":" + tagName3;
//        extRocketMQTemplate.convertAndSend(destination3, "Hello, extRocketMQTemplate!");

        //不需要手动执行rocketMQTemplate.destroy()方法， rocketMQTemplate会在spring容器销毁时自动销毁。
//        rocketMQTemplate.destroy(); // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate
    }

    //异步发送
    public void sendEntity() {
        try {
            //rocketMQTemplate.convertAndSend(RocketMQConfig.TOPIC2, new OrderPaidEvent("T_001", new BigDecimal("88.00")));
            //异步发送
            rocketMQTemplate.asyncSend(RocketMQConfig.TOPIC2, new OrderPaidEvent("T_001", new BigDecimal("88.00")), new SendCallback() {
                public void onSuccess(SendResult var1) {
                    System.out.printf("async onSucess SendResult=%s %n", var1);
                }

                public void onException(Throwable var1) {
                    System.out.printf("async onException Throwable=%s %n", var1);
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //消息轨迹
    public void sendTrace() {
        rocketMQTemplate.convertAndSend(RocketMQConfig.TOPIC4, "Hello, World!");
    }

    //发送批量消息
    //If you just send messages of no more than 1MiB at a time, it is easy to use batch
    //Messages of the same batch should have: same topic, same waitStoreMsgOK and no schedule support
    private void sendBatchMessages() {
        List<Message> msgs = new ArrayList<Message>();
        for (int i = 0; i < 10; i++) {
            msgs.add(MessageBuilder.withPayload("Hello RocketMQ Batch Msg#" + i).
                    setHeader(RocketMQHeaders.KEYS, "KEY_" + i).build());
        }
        SendResult sr = rocketMQTemplate.syncSend(RocketMQConfig.TOPIC1, msgs, 60000);
        System.out.printf("--- Batch messages send result :" + sr);
    }
}
