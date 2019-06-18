package com.xujian.thinking.threads;

/**
 * @author xujian 线程安全 共享变量
 */
public class ThreadShareVarliable implements ITester {

    @Override
    public void Test() {
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        // t1.start();
        // t2.start();
    }

    Runnable r = new Runnable() {

        // i被共享使用
        int i = 100;

        @Override
        public void run() {
            while (true) {
                i--;
                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }
    };
}