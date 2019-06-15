package com.xujian.springcloudmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建消息队列
 * <p>
 * 用来配置队列、交换器、路由等高级信息
 */
@Configuration
public class RabbitMQConfig {
    public static final String queueName = "sender1-queue";
    public static final String sender1ExchangeName = "sender1.test";
//    public static final String sender2ExchangeName = "sender2.test";
    public static final String routeKey = "foo.bar.#"; //foo.bar.* //路由规则
    public static final String routingkey = "foo.bar.baz";

    @Bean(name = queueName)
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(RabbitMQConfig.sender1ExchangeName);
    }

    //根据这里设定的路由规则，交换机topicExchangeName 绑定 routeKey
    //符合该规则的消息才会被接收
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routeKey);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(RabbitMQConfig.queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        //Receiver.receiveMessage()
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

//    @Bean //connectionFactory
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        return rabbitTemplate;
//    }
}
