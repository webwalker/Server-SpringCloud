package com.xujian.rabbitmq.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by xujian on 2019-06-20
 */
public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("ack-消息发送到exchange成功.");
        } else {
            System.out.println("nack-发送到exchange失败,需手工处理该消息，原因: " + cause);
        }
        //resend(rabbitTemplate, correlationData, cause);
    }

    //从记录的map中尝试重新发送
    private void resend(RabbitTemplate rabbitTemplate, CorrelationData correlationData, boolean ack, String cause) {
//        if (null != cause && !"".equals(cause)) {
//            System.out.println("失败原因:" + cause);
//            // 重发的时候到redis里面取,消费成功了，删除redis里面的msgId
//            Message message = messageMap.get(correlationData.getId());
//            rabbitTemplate.convertAndSend("", "", message, correlationData);
//        } else {
//            messageMap.remove(correlationData.getId());
//            System.out.println("消息唯一标识:" + correlationData + ";确认结果:" + ack);
//        }
    }
}
