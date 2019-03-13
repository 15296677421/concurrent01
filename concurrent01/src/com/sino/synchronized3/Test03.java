package com.sino.synchronized3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Reentarntlock
  *  �ɴ��
  *  ����״̬��������ͨ�������ȴ����У����ض���
  * ��ͨ������sleep(),���Ա���ϣ�����Thread.interrupt()���������Դ������״̬�׳��쳣
  * �ȴ����У�wait()���������ã�Ҳ��һ������״̬��ֻ����notify���ѡ��޷����
  * ���ض��� ���޷���ȡ�����
  * ʹ��ReentrantLock��lock��������ȡ����ǵ�ʱ�������Ҫ�����ȴ�����ǣ��޷�������
  * ʹ��ReentrantLock��lockInterruptibly��������ȡ����ǵ�ʱ�������Ҫ�����ȴ�����ǿ��Ա����
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
			lock.lockInterruptibly(); //���Դ�ϣ������ȴ��������Ա��������̴߳�������״̬  
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
	    t2.interrupt(); // ����߳����ߡ���������������״̬���̣߳������׳��쳣
	}
}
