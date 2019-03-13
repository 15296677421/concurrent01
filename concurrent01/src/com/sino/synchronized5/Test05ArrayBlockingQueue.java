package com.sino.synchronized5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/**
 * 1 并发容器
 * 2 有界容器
 *
 */
public class Test05ArrayBlockingQueue {
    final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
    
    public static void main(String[] args) {
		final Test05ArrayBlockingQueue t = new Test05ArrayBlockingQueue();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("add method :" + t.queue.add("value" + i));
			try {
				t.queue.put("put" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("put method : " + i);
			System.out.println("offer method : " + t.queue.offer("value" + i));
			try {
				System.out.println("offer method : " +t.queue.offer("value" + i, 1, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
