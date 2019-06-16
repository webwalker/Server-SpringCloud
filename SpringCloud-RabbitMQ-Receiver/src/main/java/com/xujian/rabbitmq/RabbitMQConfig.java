package com.xujian.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建消息队列
 * <p>
 * 用来配置队列、交换器、路由等高级信息
 */
@Configuration
public class RabbitMQConfig {
    //topic exchange
    public static final String topicExchangeName = "sender.topic";

    public static final String sender1RouteKey = "sender1.#"; //foo.bar.* //路由规则
    public static final String sender1QueueName = "sender1.queue";
    public static final String sender2RouteKey = "sender2.#";
    public static final String sender2QueueName = "sender2.queue";

    //direct exchange
    public static final String directExchangeName = "sender.direct";
    public static final String sender3RouteKey = "sender3.#";
    public static final String sender3QueueName = "sender3.queue";

    //可定义失败的交换机和队列单独处理异常
    //可将重试的消息发送到重试队列中，单独处理，隔离开

    @Bean
    @Qualifier(value = "queue1")
    Queue queue1() {
        // exclusive 表示该队列是否只在当前Connection生效，默认false

        //Map<String, Object> args = new ConcurrentHashMap<>(3);
        //args.put("x-dead-letter-exchange", "");
        //args.put("x-dead-letter-routing-key", "");
        //return QueueBuilder.durable().withArgument(args).build();

        return new Queue(sender1QueueName);
    }

    @Bean
    @Qualifier(value = "queue2")
    Queue queue2() {
        return new Queue(sender2QueueName);
    }

    @Bean
    @Qualifier(value = "queue3")
    Queue queue3() {
        return new Queue(sender3QueueName);
    }

    @Bean
    @Qualifier(value = "topic.exchange")
    Exchange exchange1() {
        return ExchangeBuilder.topicExchange(topicExchangeName).build();
//        return new TopicExchange(topicExchangeName);
    }

    @Bean
    @Qualifier(value = "direct.exchange")
    Exchange exchange2() {
        return ExchangeBuilder.directExchange(directExchangeName).build();
//        return new DirectExchange(directExchangeName);
    }

    @Bean
    Binding bindingTopic1(@Qualifier(value = "queue1") Queue queue,
                          @Qualifier(value = "topic.exchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(sender1RouteKey).noargs();
    }

    @Bean
    Binding bindingTopic2(@Qualifier(value = "queue2") Queue queue,
                          @Qualifier(value = "topic.exchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(sender2RouteKey);
    }

    //direct类型时可直接发送到队列，会采用默认的exchange、routekey
    //routekey和queue名称保持一致
    @Bean
    Binding bindingDirect(@Qualifier(value = "queue3") Queue queue,
                          @Qualifier(value = "direct.exchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(sender3RouteKey);
    }


//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        //ExecutorService service = Executors.newFixedThreadPool(20); //500个线程的线程池
//        //factory.setExecutor(service);
//        return factory;
//    }

//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        return rabbitAdmin;
//    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    //自定义接收--->start
    //这里也可以进行confirm操作
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(RabbitMQConfig.sender1QueueName);
//        //ExecutorService executorService = Executors.newFixedThreadPool(300);  //300个线程的线程池
//        //container.setTaskExecutor(executorService);
//        //在配置中已配置
//        //container.setConcurrentConsumers(10);
//
//        //container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        //container.setDefaultRequeueRejected(false);
//        //严格按照顺序执行
//        //container.setExclusive(false);
//        container.setMessageListener(listenerAdapter);
//        /*container.setMessageListener(new ChannelAwareMessageListener() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                try{
//                    channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//                    logger.info("接收消息：{}",new String(message.getBody()));
//                }catch (Exception ex){
//                    //channel.basicReject
//                    //channel.basicNack
//                }
//            }
//        });*/
//        return container;
//    }

    //
    //消息监听
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        //Receiver.receiveMessage()
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

    //为了监听队列的配置, 和..差不多，包装
//    @Bean
//    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        ExecutorService service = Executors.newFixedThreadPool(600);
//        factory.setTaskExecutor(service);
//        factory.setConcurrentConsumers(500);
//        factory.setPrefetchCount(5);
//        configurer.configure(factory, connectionFactory());
//        return factory;
//    }
    //自定义接收--->end
}
