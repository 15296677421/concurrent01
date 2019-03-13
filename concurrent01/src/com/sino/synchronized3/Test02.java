package com.sino.synchronized3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Reentarntlock
 * ������
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
    		// ������������������޷���ȡ����ǣ�����false
    		// �����ȡ����ǣ�����true
			isLocked = lock.tryLock();
			
			// �������������������������ʱ�������Ի�ȡ�����
			// �����ʱ�����ȴ���ֱ�ӷ���
			
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
