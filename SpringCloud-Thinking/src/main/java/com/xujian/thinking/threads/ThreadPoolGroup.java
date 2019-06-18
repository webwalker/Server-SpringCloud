package com.xujian.thinking.threads;

/**
 * @author xujian 方便的对线程进行管理
 */
public class ThreadPoolGroup implements ITester {

    /**
     * 可以对线程进行遍历，知道那些线程已经运行完毕，还有那些线程在运行
     * 通过ThreadGroup.activeCount知道有多少线程从而可以控制插入的线程数
     */
    @Override
    public void Test() {

        ThreadGroup tg = new ThreadGroup("My Group");
        MyThread thrd1 = new MyThread(tg, "MyThread #1");
        MyThread thrd2 = new MyThread(tg, "MyThread #2");
        MyThread thrd3 = new MyThread(tg, "MyThread #3");

        // 或 Thread t1 = new Thread(tg, new MyThread());

        thrd1.start();
        thrd2.start();
        thrd3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

        System.out.println(tg.activeCount() + " threads in thread group.");

        Thread thrds[] = new Thread[tg.activeCount()];
        tg.enumerate(thrds);
        for (Thread t : thrds)
            System.out.println(t.getName());

        thrd1.myStop();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(tg.activeCount() + " threads in tg.");
        tg.interrupt();
    }

    class MyThread extends Thread {
        boolean stopped;

        public MyThread() {
        }

        MyThread(ThreadGroup tg, String name) {
            super(tg, name);
            stopped = false;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " starting.");
            try {
                for (int i = 1; i < 1000; i++) {
                    System.out.print(".");
                    Thread.sleep(250);
                    synchronized (this) {
                        if (stopped)
                            break;
                    }
                }
            } catch (Exception exc) {
                System.out.println(Thread.currentThread().getName()
                        + " interrupted.");
            }
            System.out.println(Thread.currentThread().getName() + " exiting.");
        }

        synchronized void myStop() {
            stopped = true;
        }
    }
}