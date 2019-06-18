package com.xujian.thinking.threads;

/**
 * @author xujian 线程2等待线程1结束后打印结果,一定意义上，它可以实现同步的功能
 */
public class ThreadJoin implements ITester {

    int sum = 0;

    @Override
    public void Test() {
        Thread t = new Thread(r);
        t.start();

        System.out.println("其他事情");
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                sum += i;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };
}