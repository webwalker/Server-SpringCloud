package com.xujian.thinking.threads;

/**
 * @author xujian
 */
public class SleepLock implements ITester {

    /**
     * t1和t2是两个对象的线程，所以当线程t1通过sleep()进入停滞时， 排程器会从线程池中调用其它的可执行线程， 从而t2线程被启动
     */
    @Override
    public void Test() {
//		TestThreadMethod1 t1 = new TestThreadMethod1("t1");
//		TestThreadMethod1 t2 = new TestThreadMethod1("t2");

        TestThreadMethod2 t1 = new TestThreadMethod2("t1");
        TestThreadMethod2 t2 = new TestThreadMethod2("t2");

        t1.start();// （1）
        // t1.start();//（2）
        t2.start();// （3）
    }

    class TestThreadMethod1 extends Thread {
        public int shareVar = 0;

        public TestThreadMethod1(String name) {
            super(name);
        }

        /**
         * 虽然在run()中执行了sleep()，但是它不会释放对象的"锁标志"，
         * 所以除非代码(1)的线程执行完run()函数并释放对象的"锁标志" ， 否则代码（2）的线程永远不会执行
         */
        public synchronized void run() {
            for (int i = 0; i < 3; i++) {
                System.out.print(Thread.currentThread().getName());
                System.out.println(" extends " + i);
                try {
                    Thread.sleep(100);// （4）
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        }
    }

    class TestThreadMethod2 extends Thread {
        public int shareVar = 0;

        public TestThreadMethod2(String name) {
            super(name);
        }

        public synchronized void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print(Thread.currentThread().getName());
                System.out.println(" extends " + i);
                try {
                    if (Thread.currentThread().getName().equals("t1"))
                        Thread.sleep(200);
                    else
                        Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        }
    }
}