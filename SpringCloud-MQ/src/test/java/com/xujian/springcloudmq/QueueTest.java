package com.xujian.springcloudmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 消息队列测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMQApplication.class)
public class QueueTest {

    @Autowired
    private Sender sender;

    /*
     * 测试消息队列
     */
    @Test
    public void test1() {
        this.sender.send("Hello RabbitMQ");
    }
}
