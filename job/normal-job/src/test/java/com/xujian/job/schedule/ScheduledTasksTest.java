package com.xujian.job.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledTasksTest {

    @SpyBean
    ScheduledTasks tasks;

    @Test
    public void reportCurrentTime() {
        tasks.reportCurrentTime();
//        await().atMost(Duration.TEN_SECONDS).untilAsserted(() -> {
//            verify(tasks, atLeast(2)).reportCurrentTime();
//        });
    }
}