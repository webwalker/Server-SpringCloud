package com.xujian.kafka;

import com.xujian.kafka.second.KafkaSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndicatorServiceTest {
    @Autowired
    IndicatorService indicatorService;

    @Autowired
    KafkaSender sender;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessMessage() throws Exception {
        indicatorService.processMessage(null);
    }

    @Test
    public void testSend1Message() throws Exception {
        indicatorService.sendMessage("topic1", "data1");
        indicatorService.sendMessage("topic2", "data2");
        indicatorService.sendMessage("topic3", "data3");
    }

    @Test
    public void testSend2Message() throws Exception {
        sender.sendChannelMess("seckill", "data2");
    }
}
