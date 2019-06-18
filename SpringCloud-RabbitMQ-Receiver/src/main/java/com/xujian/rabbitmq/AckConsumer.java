package com.xujian.rabbitmq;

import com.rabbitmq.client.Channel;
import com.xujian.rabbitmq.pojo.User;
import com.xujian.utility.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

public class AckConsumer implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(AckConsumer.class);

//    @Autowired
//    private UserService userService;

//    @Autowired
//    private MsgInfoService msgInfoService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        logger.info("接受到消息：{}", message);
        channel.basicQos(1); //每次处理一条消息
        String state = null;
        try {
            String msg = new String(message.getBody(), "utf-8");
            logger.info("处理的数据：{}", JsonUtil.toJson(msg));
            User user = JsonUtil.fromJson(msg, User.class);
            User userDto = null; //userService.save(user);
            String returnCode = ""; //userDto.getReturnCode();
            logger.info("调用结果返回：{}", JsonUtil.toJson(userDto));
            if ("1000".equals(returnCode)) {
                state = "10A";
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                state = "10I";
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);//拒绝消费消息
            }
        } catch (Exception e) {
            state = "10I";
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        } finally {
            //消息持久化
            //msgInfoService.saveMsg(message, state);
        }
    }
}

