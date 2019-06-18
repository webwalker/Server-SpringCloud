package com.xujian.rabbitmq;

import com.xujian.rabbitmq.sender.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringbootRabbitmqTest {

  @Autowired
  private MessageSender messageSender;

  @Test
  public void batchPublisherMessage() {
    for (int i = 1; i < 20; i++) {
        messageSender.asyncSend("异步发送消息------" + i);
    }
  }
}
