/**
 * 
 */
package com.xujian.thinking.threads;

/**
 * @author xujian
 * 
 */
public class ThreadDeadLock implements ITester {

	@Override
	public void Test() {
		TestThread r = new TestThread();
		Thread t = new Thread(r);
		t.start();
	}

	public class TaskA {
		public synchronized void f1(TaskB b) {
			System.out.println("TaskA-f1");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.f2();
		}

		public synchronized void f2() {
			System.out.println("TaskA-f2");
		}
	}

	public class TaskB {
		public synchronized void f1(TaskA a) {
			System.out.println("TaskB-f1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.f2();
		}

		public synchronized void f2() {
			System.out.println("TaskB-f2");
		}
	}

	class TestThread implements Runnable {

		private TaskA a = new TaskA();
		private TaskB b = new TaskB();

		public TestThread() {
			new Thread(this).start(); // 保证此方法和该线程的run方法同时启动
			a.f1(b);
		}

		@Override
		public void run() {
			b.f1(a);
		}
	};
}
