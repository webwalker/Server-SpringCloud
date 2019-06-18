package com.xujian.utility;

import com.xujian.utility.async.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearnApplicationTests {
    @Autowired
    private AsyncTaskService task;

    @Test
    public void threadTest() {
        for (int i = 0; i < 20; i++) {
            task.executeAsyncTask(i);
        }
    }

    @Test
    public void doTaskOne() {
        try {
            task.doTaskOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doTaskTwo() {
        try {
            task.doTaskTwo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doTaskThree() {
        try {
            task.doTaskThree();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTotalTime() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(50);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}
