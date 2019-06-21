package com.xujian.rabbitmq;

import com.xujian.rabbitmq.callback.RabbitConfirmCallback;
import com.xujian.rabbitmq.callback.RabbitReturnCallback;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
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

//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        //factory.setUri("amqp://xxx.yyyy:123456@192.168.1.131:5672");
//        //factory.setPublisherConfirms(true);
//        /*factory.setCloseExceptionLogger(new ConditionalExceptionLogger() {
//            @Override
//            public void log(Log logger, String message, Throwable t) {
//                logger.exception("发送异常：" + message, t);
//            }
//        });*/
//        return factory;
//    }
//
//    //RabbitAdmin封装了对 RabbitMQ 的管理操作
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
        rabbitTemplate.setReturnCallback(new RabbitReturnCallback());
        //消息确认, yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback(new RabbitConfirmCallback());

        return rabbitTemplate;
    }
}
