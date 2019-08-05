package com.xujian.thinking.threads;

/**
 * @author xujian 生产者消费者 无同步前， 生产消费非常乱， 属性交叉 即便增加了, 线程同步也会产生问题：
 *         1、生产者多生产了数据 2、消费者多取了数据
 */
public class ProductorConsumer implements ITester {

    /**
     * 生产者-消费者（producer-consumer）问题，也称作有界缓冲区（bounded-buffer）问题，
     * 两个进程共享一个公共的固定大小的缓冲区
     * 。其中一个是生产者，用于将消息放入缓冲区；另外一个是消费者，用于从缓冲区中取出消息。问题出现在当缓冲区已经满了
     * ，而此时生产者还想向其中放入一个新的数据项的情形
     * ，其解决方法是让生产者此时进行休眠，等待消费者从缓冲区中取走了一个或者多个数据后再去唤醒它。同样地，
     * 当缓冲区已经空了，而消费者还想去取消息，此时也可以让消费者进行休眠，等待生产者放入一个或者多个数据时再唤醒它。
     * 一，首先定义公共资源类，其中的变量number是保存的公共数据。并且定义两个方法，增加number的值和减少number的值
     */
    @Override
    public void Test() {
        PublicResource resource = new PublicResource();

        for (int i = 0; i < 3; i++) {
            new Thread(new ProducerThread(resource)).start();
            new Thread(new ConsumerThread(resource)).start();
        }
    }

    /**
     * 生产者线程，负责生产公共资源
     */
    public class ProducerThread implements Runnable {
        private PublicResource resource;

        public ProducerThread(PublicResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.increace();
            }
        }
    }

    /**
     * 消费者线程，负责消费公共资源
     */
    public class ConsumerThread implements Runnable {
        private PublicResource resource;

        public ConsumerThread(PublicResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.decreace();
            }
        }
    }

    /**
     * 公共资源类 在non-synchronized函数或non-synchronized　block中进行调用，
     * 虽然能编译通过，但在运行时会发生IllegalMonitorStateException的异常
     */
    public class PublicResource {
        private int number = 0;

        /**
         * 增加公共资源
         */
        public synchronized void increace() {
            while (number != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println("increace: " + number);
            notify();
        }

        /**
         * 减少公共资源
         */
        public synchronized void decreace() {
            while (number == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println("decreace: " + number);
            notify();
        }
    }
}
