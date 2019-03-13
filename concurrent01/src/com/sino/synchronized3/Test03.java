package com.sino.synchronized3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Reentarntlock
  *  可打断
  *  阻塞状态：包括普通堵塞，等待队列，锁池队列
  * 普通堵塞：sleep(),可以被打断，调用Thread.interrupt()方法，可以打断阻塞状态抛出异常
  * 等待队列：wait()方法被调用，也是一种阻塞状态，只能由notify唤醒。无法打断
  * 锁池队列 ：无法获取锁标记
  * 使用ReentrantLock的lock方法，获取锁标记的时候，如果需要阻塞等待锁标记，无法被打算
  * 使用ReentrantLock的lockInterruptibly方法，获取锁标记的时候，如果需要阻塞等待锁标记可以被打断
 */
public class Test03 {
    Lock lock = new ReentrantLock(); 
    
    void m1() {
    	try {
    		lock.lock();
    		for(int i =0; i < 5; i++) {
    			TimeUnit.SECONDS.sleep(1);
    			System.out.println("m1() method" + i);
    		}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
    }
    
    void m2() {
    	try {
			lock.lockInterruptibly(); //尝试打断，阻塞等待锁，可以被其他的线程打算阻塞状态  
			System.out.println("m2() method");
		} catch (InterruptedException e) {
			System.out.println("m2() method interrupted");
			e.printStackTrace();
		} finally {
			try {
				lock.unlock();
			} catch (Exception e2) {
			}
		}
    }
    
    public static void main(String[] args) {
		final Test03 t = new Test03();
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
	    Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
                t.m2();				
			}
		});
	    t2.start();
	    try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    t2.interrupt(); // 打断线程休眠。非正常结束阻塞状态的线程，都会抛出异常
	}
}
