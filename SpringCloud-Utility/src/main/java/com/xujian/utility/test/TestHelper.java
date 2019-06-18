package com.xujian.utility.test;

import com.xujian.utility.SpringCloudUtilityApplication;
import com.xujian.utility.async.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Future;

/**
 * Created by xujian on 2019-06-18
 */
public class TestHelper {
    public static void test() throws Exception {
        //获取Bean, 非静态类可以通过AutoWired
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringCloudUtilityApplication.class);
        AsyncTaskService task = context.getBean(AsyncTaskService.class);

        //one
        for (int i = 0; i < 20; i++) {
            task.executeAsyncTask(i);
        }

        //two
        long start = System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(10);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}
