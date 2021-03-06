package com.sino.synchronized1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * CountDownLatch 门闩
 * 可以和锁混合使用，或替代锁的功能
 * 在门闩未完全开放之前等待。当门闩完全开放后执行
 * 避免锁的效率低下问题
 */
public class Test15 {
    CountDownLatch latch = new CountDownLatch(5);
    
    void m1() {
    	try {
			latch.await();//等待门闩开放
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("m1 method");
    }
    
    void m2() {
    	for(int i = 0; i < 10; i++) {
    		if(latch.getCount() != 0) {
    			System.out.println("latch count :" + latch.getCount());
    			latch.countDown();// 减门闩上的锁
    		}
    		try {
				TimeUnit.MICROSECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				TimeUnit.MICROSECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println("m2() method : " +i);
    	}
    }
     public static void main(String[] args) {
		final Test15 t = new Test15();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.m2(); 
			}
		}).start();
	}
}
