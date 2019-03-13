package com.sino.synchronized1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * AtomicXxx
 * ͬ������
 * ԭ�Ӳ������͡�����ÿ����������ԭ�Ӳ��������Ա�֤�̰߳�ȫ
 */
public class Test11 {
    AtomicInteger count = new AtomicInteger();
    
    void m() {
    	for(int i = 0; i < 10000; i++) {
    		count.incrementAndGet();
    	}
    }
    
    public static void main(String[] args) {
    	final Test11 t = new Test11();
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
    	System.out.println(t.count.intValue());
	}
}
