package com.sino.synchronized5;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
/**
 * 1 并发容器 - LinkedTransferQueue
 * 2 转移队列
 * 3 add - 队列会保存数据，不做阻塞等待
 * 4 transfer - 是TransferQueue的特有方法。必须有消费者;
 * 5 如果没有任意线程消费数据，transfer方法阻塞。一般用于处理即时消息
 */
public class Test07TransferQueue {
    TransferQueue<String> queue = new LinkedTransferQueue<String>();
	
    public static void main(String[] args) {
		final Test07TransferQueue t = new Test07TransferQueue();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
                try {
                	System.out.println(Thread.currentThread().getName() + "thread begin ");
					System.out.println(Thread.currentThread().getName() + "-" + t.queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "output thread").start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t.queue.transfer("test string");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t.queue.transfer("test string");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}).start();
		
		/*
		 * try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() {
		 * 
		 * try { System.out.println(Thread.currentThread().getName() + "thread begin");
		 * System.out.println(Thread.currentThread().getName() + "-" + t.queue.take());
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } }, "output thread").start();
		 */
	}
		
}
