package com.sino.synchronized4;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ������������
 * ������&����
 * ���� - Condition, Ϊlock��������������������ʱ����ʲô���飬������������
 *
 * 
 */
public class TestContainer02<E> {
    private final LinkedList<E> list = new LinkedList<E>();
    private final int MAX = 10;
    private int count = 0;
    
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();
    
    public int getCount() {
    	return count;
    }
    
    public void put(E e) {
    	lock.lock();
    	try {
    		while(list.size() == MAX) {
    			System.out.println(Thread.currentThread().getName() + "�ȴ� �� �� ��");
    			//����ȴ����С��ͷ������
    			//��������������ȴ�����
    			producer.await();
    		}
			System.out.println(Thread.currentThread().getName() + "put . . .");
			list.add(e);
			count++;
			//�����������������е�������
			consumer.signalAll();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
    }
    
    public E get() {
    	E e = null;
    	lock.lock();
    	try {
    		while(list.size() == 0) {
    			System.out.println(Thread.currentThread().getName() + "�ȴ� ������");
    			//���������������߽���ȴ�����
    			consumer.await();
    		} 
    		System.out.println(Thread.currentThread().getName() + "get . . .");
    		e = list.removeFirst();
    		count--;
    		//���������������е�������
    		producer.signalAll();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
    	return e;
    }
    
    public static void main(String[] args) {
		final TestContainer02<String> t = new TestContainer02<String>();
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
                    for(int j = 0; j < 5; j++) {
                    	System.out.println(t.get());
                    }					
				}
			},"consumer" + i).start();
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 2; i++) {
		    new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 25; j++) {
						t.put("container" + j);					}
				}
			}, "producer" + i).start();
		}
	}
}
