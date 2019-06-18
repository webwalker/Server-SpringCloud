package com.xujian.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.xujian.rabbitmq.service.MessageHandler;
import com.xujian.rabbitmq.util.RabbitMqUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
@Slf4j
public class SupplyRabbitMqConsumer {

  @Resource
  private RabbitTemplate rabbitTemplate;

  @Resource
  private MessageHandler messageHander;

  @Value("${java.rabbitmq.consumer.service.retry.exchange}")
  private String supplyServiceListenerRetryExchange;

  @Value("${java.rabbitmq.consumer.service.fail.exchange}")
  private String supplyServiceListenerFailExchange;

  @Value("${java.rabbitmq.consumer.service.supply.retry.routingkey}")
  private String supplySerivceRetryOrFailRoutingKey;

  @RabbitListener(queues = {"material@supply"})
  public void consumerMessage(Message message, Channel channel) throws IOException {
    try {
      messageHander.HandlerMessage(message, "supply");
    } catch (Exception e) {
      long retryCount = RabbitMqUtil.getRetryCount(message.getMessageProperties());
      CorrelationData correlationData =
          new CorrelationData(message.getMessageProperties().getCorrelationId());
      Message newMessage = null;
      if (retryCount >= 3) {
        newMessage = RabbitMqUtil.buildMessage(message);
        try {
          // 这里routingkey设置为自己的原因是，当下次消费的时候，只有自己才能收到消息，因为可能有很多个
          // 消费者都再监听某个队列，但是他们的routingkey必须不一样才行
          rabbitTemplate.convertAndSend(supplyServiceListenerFailExchange,
              supplySerivceRetryOrFailRoutingKey, newMessage, correlationData);
          log.info("供需关系服务消费消息:" + new String(message.getBody()) + "重试3次后放到死信队列待人工处理");
        } catch (Exception e1) {
          log.error("供需关系服务消息在发送到fail队列的时候报错:" + e1.getMessage() + ",原始消息:"
              + new String(newMessage.getBody()));
        }
      } else {
        newMessage = RabbitMqUtil.buildMessage2(message);
        try {
          /** 如果当前消息被重试的次数小于3,则将消息发送到重试队列,等待重新被消费，也是异步发送，最多发送3次 */
          rabbitTemplate.convertAndSend(supplyServiceListenerRetryExchange,
              supplySerivceRetryOrFailRoutingKey, newMessage, correlationData);
        } catch (Exception e1) {
          log.info("供需关系服务消费消息:" + new String(message.getBody()) + "失败原因:" + e1.getMessage()
              + ",重试次数:" + retryCount);

        }
      }
    } finally {
      /**
       * 关闭rabbitmq的自动ack,改为手动ack 1、因为自动ack的话，其实不管是否成功消费了，rmq都会在收到消息后立即返给生产者ack,但是很有可能 这条消息我并没有成功消费
       * 2、无论消费成功还是消费失败,都要手动进行ack,因为即使消费失败了,也已经将消息重新投递到重试队列或者失败队列
       * 如果不进行ack,生产者在超时后会进行消息重发,如果消费者依然不能处理，则会存在死循环
       */
      channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
  }

}
