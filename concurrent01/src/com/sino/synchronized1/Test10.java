package com.sino.synchronized1;

import java.util.ArrayList;
import java.util.List;
/**
 * volatile 关键字
 * volatile的非原子性问题
 * volatile只能保证可见性，不能保证原子性
 */
public class Test10 {
    volatile int count = 0;
    synchronized void m() {
    	for(int i = 0; i < 1000; i++) {
    		count++;
    	}
    }
    
    public static void main(String[] args) {
		final Test10 t = new Test10();
		List<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i < 10; i++) {
			threads.add(new Thread(new Runnable() {
				@Override
				public void run() {
					t.m();
				}
			}));
		}
		for(Thread thread : threads) {
			thread.start();
		}
		
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(t.count);
	}
}
