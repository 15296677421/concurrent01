package com.sino.synchronized1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * CountDownLatch ����
 * ���Ժ������ʹ�ã���������Ĺ���
 * ������δ��ȫ����֮ǰ�ȴ�����������ȫ���ź�ִ��
 * ��������Ч�ʵ�������
 */
public class Test15 {
    CountDownLatch latch = new CountDownLatch(5);
    
    void m1() {
    	try {
			latch.await();//�ȴ����ſ���
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
    			latch.countDown();// �������ϵ���
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
