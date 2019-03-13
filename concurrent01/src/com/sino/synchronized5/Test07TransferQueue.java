package com.sino.synchronized5;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
/**
 * 1 �������� - LinkedTransferQueue
 * 2 ת�ƶ���
 * 3 add - ���лᱣ�����ݣ����������ȴ�
 * 4 transfer - ��TransferQueue�����з�����������������;
 * 5 ���û�������߳��������ݣ�transfer����������һ�����ڴ���ʱ��Ϣ
 */
public class Test07TransferQueue {
    TransferQueue<String> queue = new LinkedTransferQueue<String>();
	
    public static void main(String[] args) {
		final Test07TransferQueue t = new Test07TransferQueue();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
                try {
                	System.out.println(Thread.currentThread().getName() + "thread begin ");
					System.out.println(Thread.currentThread().getName() + "-" + t.queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "output thread").start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t.queue.transfer("test string");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t.queue.transfer("test string");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}).start();
		
		/*
		 * try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() {
		 * 
		 * try { System.out.println(Thread.currentThread().getName() + "thread begin");
		 * System.out.println(Thread.currentThread().getName() + "-" + t.queue.take());
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } }, "output thread").start();
		 */
	}
		
}
