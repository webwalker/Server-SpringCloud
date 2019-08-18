package com.xujian.rocketmq.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerGuavaBasic {
    @Autowired
    private SyncProducer syncProducer;

    @Autowired
    private AsyncProducer asyncProducer;

    @Autowired
    private OnewayProducer onewayProducer;

    @Test
    public void SyncProducer() {
        try {
            syncProducer.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AsyncProducer() {
        try {
            asyncProducer.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void OnewayProducer() {
        try {
            onewayProducer.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}