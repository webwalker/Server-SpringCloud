package com.xujian.rocketmq.producer;

import com.xujian.rocketmq.sender.SenderNormal;
import com.xujian.rocketmq.sender.SenderTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderGuavaBasic {
    @Autowired
    private SenderNormal senderNormal;

    @Autowired
    private SenderTransaction transaction;

    @Test
    public void sendString() {
        senderNormal.sendString();
    }

    @Test
    public void sendEntity() {
        senderNormal.sendEntity();
    }

    @Test
    public void sendTransaction() {
        transaction.run();
    }

    @Test
    public void sendTrace() {
        senderNormal.sendTrace();
    }
}