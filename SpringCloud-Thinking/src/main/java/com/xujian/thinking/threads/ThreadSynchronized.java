package com.xujian.thinking.threads;

/**
 * @author xujian 单线程处理
 */
public class ThreadSynchronized implements ITester {

    @Override
    public void Test() {
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }

    Runnable r = new Runnable() {

        private int ticketNum = 10;

        @Override
        public void run() {
            while (true) {
                // 或者SellTicket();
                synchronized (this) {
                    if (ticketNum == 0) {
                        System.out.println("没有票了");
                        break;
                    } else {
                        try {
                            Thread.currentThread().sleep(1000);
                            ticketNum--;
                            System.out.println(Thread.currentThread().getName()
                                    + "卖出一张，还剩" + ticketNum);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        synchronized void SellTicket() {
            if (ticketNum == 0) {
                System.out.println("没有票了");
                return;
            } else {
                try {
                    Thread.currentThread().sleep(1000);
                    ticketNum--;
                    System.out.println(Thread.currentThread().getName()
                            + "卖出一张，还剩" + ticketNum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };
}
