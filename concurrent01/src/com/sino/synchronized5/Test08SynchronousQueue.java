package com.sino.synchronized5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 1 并发容器- SynchronousQueue
 * 2 有界容器
 * 
 *
 */
public class Test08SynchronousQueue {
    BlockingQueue<String> queue = new SynchronousQueue<String>();
    
    public static void main(String[] args) {
		Test08SynchronousQueue t = new Test08SynchronousQueue();
	    
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " thread begin ");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					System.out.println(Thread.currentThread().getName() + "-" + t.queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "output thread").start();
		
		t.queue.add("test add");
		try {
			t.queue.put("test put");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " queue size " + t.queue.size());
	}
}
