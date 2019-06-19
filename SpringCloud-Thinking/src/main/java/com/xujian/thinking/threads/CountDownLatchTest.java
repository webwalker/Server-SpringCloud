package com.xujian.thinking.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xujian on 2019-06-18
 */
public class CountDownLatchTest implements ITester {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void Test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2); //定义为两个工人的协作

        Worker worker1 = new Worker("张三", 2000, latch);
        Worker worker2 = new Worker("李四", 4000, latch);
        worker1.start();
        worker2.start();

        //latch.countDown();
        latch.await(); //等待所有工人完成工作
        //latch.await(10000, TimeUnit.MILLISECONDS);
        System.out.println("工人活都干完了，老板开始检查了! " + sdf.format(new Date()));
    }

    public void Test2() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(2);
        Worker worker1 = new Worker("张三", 2000, latch);
        Worker worker2 = new Worker("李四", 4000, latch);

        executor.execute(worker1);
        executor.execute(worker2);

        latch.await();

        executor.shutdown();
    }

    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run() {
            System.out.println(workerName + " 正在干活: " + sdf.format(new Date()));
            doWork();//工作了
            System.out.println(workerName + " 活干完了: " + sdf.format(new Date()));
            latch.countDown(); //工人完成工作，计数减一，否则await会一直等待
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
