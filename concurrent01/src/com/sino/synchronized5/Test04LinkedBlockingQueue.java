package com.sino.synchronized5;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/**
 * 1 �������� LinkedBlockingQueue
 * 2 ��������
 * 3 put & take �Զ�����
 * 4 put�Զ������� �������������Զ�����
 * 5 take�Զ���������������Ϊ0���Զ�����
 */
public class Test04LinkedBlockingQueue {
    final BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    final Random r = new Random();
    
    public static void main(String[] args) {
		final Test04LinkedBlockingQueue t = new Test04LinkedBlockingQueue(); 
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
	                	t.queue.put("value"+t.r.nextInt(1000));
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}	
		},"producer").start();
				
		     
		
		for(int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
                    while(true) {
                    	try {
							System.out.println(Thread.currentThread().getName() + "-" + t.queue.take());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }					
				}
			},"consumer" + i).start();
		}
	}
}
