package com.sino.synchronized3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
  * ��ƽ��
 *
 */
public class Test04 {
    public static void main(String[] args) {
		TestReentrantlock t = new TestReentrantlock();
    	//TestSync t = new TestSync();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		t2.start();
	}
}

class TestReentrantlock extends Thread{
	//����һ����ƽ��
	private static ReentrantLock lock = new ReentrantLock(true);
	public void run() {
		for(int i = 0; i < 5; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + "get lock");
			} finally {
				lock.unlock();
			}
		}
	}
}

class TestSync extends Thread {
	public void run() {
		for(int i = 0; i < 5; i++) {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + "get lock in TestSync");
			}
		}
	}
}