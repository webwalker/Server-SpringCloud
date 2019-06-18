package com.xujian.thinking.threads;

/**
 * @author xujian 线程中断 中断后继续执行
 */
public class ThreadInterupt implements ITester {

    Thread t = Thread.currentThread();

    @Override
    public void Test() {
        try {
    /*		Thread thread = new Thread(r, "My Thread");
			System.out.println("Starting thread...");
			thread.start();
			// Thread.sleep(3000);
			System.out.println("Interrupting thread..."
					+ thread.isInterrupted());
			thread.interrupt();
			System.out.println("线程是否中断：" + thread.isInterrupted());
			// Thread.sleep(3000);
			System.out.println("Stopping application...");
*/
            System.out
                    .println("current thead is interupt " + t.isInterrupted());
            t.interrupt();
            System.out
                    .println("current thead is interupt " + t.isInterrupted());

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("current thead is interupted");
            }

            System.out
                    .println("current thead is interupt " + t.isInterrupted());
        } catch (Exception e) {

        }
    }

    Runnable r = new Runnable() {
        boolean stop = false;

        public void run() {
            while (!stop) {
                System.out.println("My Thread is running...");
                // 让该循环持续一段时间，使上面的话打印次数少点
                long time = System.currentTimeMillis();
                while ((System.currentTimeMillis() - time < 1000)) {
                }
            }
            System.out.println("My Thread exiting under request...");
        }
    };

    Runnable r2 = new Runnable() {
        public void run() {

            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "已被中断");
            }
        }
    };
}