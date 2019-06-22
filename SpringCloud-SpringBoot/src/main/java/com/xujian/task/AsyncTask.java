package com.xujian.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    /*
     * 可以利用Future<T>来进行回调
     */
    @Async
    public Future<String> test1() {
        System.out.println("开始一");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束一");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> test2() {
        System.out.println("开始二");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束二");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> test3() {

        System.out.println("开始三");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束三");
        return new AsyncResult<>("任务三完成");
    }

}
