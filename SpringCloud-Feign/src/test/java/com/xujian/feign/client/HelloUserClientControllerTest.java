package com.xujian.feign.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloUserClientControllerTest {
    @InjectMocks
    HelloClientController helloClientController;

    @Test
    public void testHello() throws Exception {
        String result = helloClientController.hello("p1", "p2");
        System.out.println(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme