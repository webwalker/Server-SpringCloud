package com.xujian.thinking.threads;

/**
 * @author xujian
 *
 */
public class SuspendResume implements ITester {

    @Override
    public void Test() {
        TestThreadMethod t1 = new TestThreadMethod("t1");
        TestThreadMethod t2 = new TestThreadMethod("t2");
        t1.start();// （5）
        // t1.start();　//（3）
        t2.start();// （4）
    }

    class TestThreadMethod extends Thread {
        public int shareVar = 0;

        public TestThreadMethod(String name) {
            super(name);
        }

        public synchronized void run() {
            if (shareVar == 0) {
                for (int i = 0; i < 5; i++) {
                    shareVar++;
                    if (shareVar == 5) {
                        //this.suspend();// （1）过期
                    }
                }
            } else {
                System.out.print(Thread.currentThread().getName());
                System.out.println(" shareVar = " + shareVar);
                //this.resume();// （2）过期
            }
        }
    }
}