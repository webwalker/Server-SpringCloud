package com.xujian.thinking.threads;

/**
 * 一个传统的线程类
 */
public class ABasicThread implements ITester {
    @Override
    public void Test() {
        /** 第一种实现方式, 重写 run 方法 */
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1 " + Thread.currentThread().getName());
                }
            }
        };
        thread.start();

        /** 第二种方式,实现Runnable 接口 */
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2 " + Thread.currentThread().getName());
                }
            }
        });
        thread2.start();

        /**
         * 第三种方式,(){}这种写法表示定义了一个子类,此时()里面是空的,等于11行 Thread(new Runnable())
         * 这表示在构造方法中定义了一个类 因此代码执行顺序，先走打印 thread这行，再到构造方法中运行 打印runnable
         * 由于Runnable 是父接口，子类已有run方法，代码只会走子类，永远不会走 打印runnable
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("runnable "
                            + Thread.currentThread().getName());
                }
            }
        }) {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread "
                            + Thread.currentThread().getName());
                }
            }
        }.start();
    }
}