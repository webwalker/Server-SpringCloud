package com.xujian.thinking.threads;

/**
 * @author xujian
 */
public class ThreadYield implements ITester {

    @Override
    public void Test() {
        TestThreadMethod t1 = new TestThreadMethod("t1");
        TestThreadMethod t2 = new TestThreadMethod("t2");
        t1.start();// £¨1£©
        t2.start();// £¨2£©
    }

    class TestThreadMethod extends Thread {
        public int shareVar = 0;

        public TestThreadMethod(String name) {
            super(name);
        }

        public synchronized void run() {
            for (int i = 0; i < 4; i++) {
                System.out.print(Thread.currentThread().getName());
                System.out.println(" extends " + i);
                Thread.yield();
            }
        }
    }

}