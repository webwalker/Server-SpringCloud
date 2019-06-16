package com.xujian.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建消息队列
 * <p>
 * 用来配置队列、交换器、路由等高级信息
 */
@Configuration
public class RabbitMQConfig {
    public static final String topicExchangeName = "sender.topic";
    public static final String sender1key = "sender1.hahaha";
    public static final String sender2key = "sender2.hahaha";

    public static final String directExchangeName = "sender.direct";
    public static final String sender3key = "sender3.hahaha";

    private Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);

//    @Bean
//    public ConnectionFactory connectionFactory(){
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        factory.setUri("amqp://xxx.yyyy:123456@192.168.1.131:5672");
//        //factory.setPublisherConfirms(true);
//        return factory;
//    }
//
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        return rabbitAdmin;
//    }

    /**
     * 定制化amqp模版
     * <p>
     * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
     * ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack
     */
    @Bean
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //消息发送失败时返回给发送者(如为false会直接丢弃), yml需要配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);
        //消息返回, yml需要配置 publisher-returns: true
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationId();
            System.out.println(String.format("消息：{%s} 发送失败, 应答码：{%s} 原因：{%s} 交换机: {%s}  路由键: {%s}", correlationId, replyCode, replyText, exchange, routingKey));
        });
        //消息确认, yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                System.out.println("ack-消息发送到exchange成功.");
            } else {
                System.out.println("nack-发送到exchange失败,需手工处理该消息，原因: " + cause);
            }
            //resend(rabbitTemplate, correlationData, cause);
        });

        return rabbitTemplate;
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
