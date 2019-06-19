package com.xujian.thinking.threads;

/**
 * Created by xujian on 2019-06-18
 */
public class WaitNotify implements ITester {
    public Object lock = new Object();

    private volatile boolean thread1Finish = false;
    private volatile boolean thread2Finish = false;

    @Override
    public void Test() {
        final Object object = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                System.out.println("T1 start!");
                try {
                    Thread.sleep(3000);
                    object.wait();//让出锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end!");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (object) {
                System.out.println("T2 start!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //wait后如果没有其它线程将它notify，是不可能重新启动的
                object.notify(); //唤醒等待的线程，唤醒后t1等待启动
                System.out.println("T2 end!");
            }
        });
        t1.start();
        t2.start();
    }

    public class Thread1 extends Thread {
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        System.out.println("Thread1正在运行");
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        lock.wait();
                        System.out.println("Thread1正在wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class Thread2 extends Thread {
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread2在运行");
                    try {
                        lock.wait();
                        System.out.println("Thread2正在wait");
                        lock.notify();
                        System.out.println("Thread2正在notify");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
