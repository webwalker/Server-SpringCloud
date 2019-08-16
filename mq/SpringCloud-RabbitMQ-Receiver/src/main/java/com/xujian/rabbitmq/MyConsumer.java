package com.xujian.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xujian.rabbitmq.consumer.BaseConsumer;

import java.io.IOException;

public class MyConsumer extends DefaultConsumer implements BaseConsumer {
    //接收channel
    private Channel channel;

    public MyConsumer(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope,
                               AMQP.BasicProperties properties, byte[] body) throws IOException {
        //防止异常后channel关闭
        try {
            System.err.println("-----------consume message----------");
            System.err.println("consumerTag: " + consumerTag);
            System.err.println("envelope: " + envelope);
            //System.err.println("properties: " + properties);

            String msg = new String(body, "utf-8");
            System.err.println("body: " + msg);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //手工ACK，参数multiple表示不对之前的消息进行批量签收
            channel.basicAck(envelope.getDeliveryTag(), false);
        }
    }
}
