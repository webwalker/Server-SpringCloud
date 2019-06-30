package com.xujian.kafka;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndicatorServiceTest {
    @Mock
    Logger LOG;
    @Mock
    KafkaTemplate<Integer, String> kafkaTemplate;
    @InjectMocks
    IndicatorService indicatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessMessage() throws Exception {
        indicatorService.processMessage(null);
    }

    @Test
    public void testSendMessage() throws Exception {
        indicatorService.sendMessage("topic", "data");
    }
}
