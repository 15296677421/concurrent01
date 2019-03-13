package com.sino.synchronized3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentarntlock
 * (重入锁)
 */
public class Test01 {
    Lock lock = new ReentrantLock();
    
    void m1() {
    	try {
    		lock.lock(); //加锁
    		for(int i = 0; i < 10; i++) {
    			TimeUnit.SECONDS.sleep(1);
    			System.out.println("m1() method" + i);
    		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock(); //解锁
		}
    }
    
    void m2() {
    	lock.lock(); 
    	System.out.println("m2() method");
    	lock.unlock();
    }
    
    public static void main(String[] args) {
		final Test01 t = new Test01();
		new Thread(new Runnable() {
			@Override
			public void run() {
                t.m1();				
			}
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m2();
			}
		}).start();
	}
}
