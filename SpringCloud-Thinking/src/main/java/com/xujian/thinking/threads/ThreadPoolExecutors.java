package com.xujian.thinking.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xujian
 */
public class ThreadPoolExecutors implements ITester {
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        }
    }

    /**
     * ExecutorService的功能没有想像中的那么好，而且最多只是提供一个线程的容器而已， 可使用ThreadGroup替代
     */
    @Override
    public void Test() {
        SingleThreadPool();
        // FixedThreadPool();
        // CachedThreadPool();
//		ScheduedThreadPool();
//		ScheduedFixedRateThreadPool();
    }

    private void SingleThreadPool() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        threadPool.execute(new MyThread());
    }

    private void FixedThreadPool() {
        // 创建一个可重用固定大小的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        // 关闭线程池
        pool.shutdown();
    }

    private void CachedThreadPool() {
        // 创建缓存线程池, 缓存的线程池就是说当任务来了，程序运行不过来了,
        // 就自动增加新的线程 程序的线程个数是不定的
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            // 往池子里放10个任务
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 10; j++) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("线程: "
                                + Thread.currentThread().getName() + "  针对第 "
                                + task + " 次任务" + " 第   " + j + " 次循环\n");
                    }
                }
            });
        }
        System.out.println("all of 10 tasks  已经完成!");
        threadPool.shutdown();// 当任务都做完了，将线程池干掉
    }

    private void ScheduedThreadPool() {
        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Schedued bombing...");
            }
        }, 5, TimeUnit.SECONDS);

        // ExecutorService servcie =
        // ScheduledExecutorService servcie =
        // Executors.newScheduledThreadPool(3);
    }

    private void ScheduedFixedRateThreadPool() {
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("FixedRate bombing...");
            }
        }, 5, 2, TimeUnit.SECONDS);

    }
}