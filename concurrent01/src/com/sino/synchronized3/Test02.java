package com.sino.synchronized3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Reentarntlock
 * 尝试锁
 */
public class Test02 {
    Lock lock = new ReentrantLock();
    
    void m1() {
    	try {
    		lock.lock();
    		for(int i = 0; i < 10; i++) {
    			TimeUnit.SECONDS.sleep(1);
    			System.out.println("m1() method " + i);
    		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
    }
    
    void m2() {
    	boolean isLocked = false;
    	try {
    		// 尝试锁，如果有锁，无法获取所标记，返回false
    		// 如果获取所标记，返回true
			isLocked = lock.tryLock();
			
			// 阻塞尝试锁，阻塞参数代表的时长，尝试获取锁标记
			// 如果超时，不等待。直接返回
			
			//isLocked = lock.tryLock(5, TimeUnit.SECONDS);
			if(isLocked) {
				System.out.println("m2() method synchronized");
			} else {
				System.out.println("m2() method unsynchronized");
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(isLocked) {
				lock.tryLock();
			}
		}
    }
    
    public static void main(String[] args) {
		final Test02 t = new Test02();
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
