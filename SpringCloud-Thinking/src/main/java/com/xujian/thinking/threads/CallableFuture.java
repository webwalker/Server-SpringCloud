package com.xujian.thinking.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xujian 程序启动一个线程，完了之后会一个返回结果，任务可以取消
 */
public class CallableFuture implements ITester {
    @Override
    public void Test() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // Future 表示结果类
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(4000);
                return "hello";
            }
        });
        System.out.println("future isDone:" + future.isDone());
        System.out.println("等待结果");
        try {
            System.out.println("拿到结果：" + future.get()); //阻塞直到结果就绪
            System.out.println("future isDone:" + future.isDone());
            // future.cancel(false);
            // System.out.println("future isCancelled：" + future.isCancelled());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 提交一组任务
        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
                threadPool2);
        for (int i = 1; i <= 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    // 不超过5s, 最多5s
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("completionService get "
                        + completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}