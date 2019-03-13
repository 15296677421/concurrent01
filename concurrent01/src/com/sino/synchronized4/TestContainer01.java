package com.sino.synchronized4;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
/**
 * ������������
 * wait&notify
 *wait/notify���Ǹ�while���Ӧ�á����Ա�����̲߳����ж��߼�ʧЧ����
 * @param <E>
 */
public class TestContainer01<E> {
    private final LinkedList<E> list = new LinkedList<E>();
    private final int MAX = 10;
    private int count = 0;
    
    public synchronized int getCount() {
    	return count;
    }
    
    public synchronized void put(E e) {
    	while(list.size() == MAX) {
    		try {
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	list.add(e);
    	count++;
    	this.notifyAll();
    }
    
    public synchronized E get() {
    	E e = null;
    	while(list.size() == 0) {
    		try {
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	e = list.removeFirst();
    	count--;
    	this.notifyAll();
    	return e;
    }
    
    public static void main(String[] args) {
		final TestContainer01<String> c = new TestContainer01<String>();
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
                  	for(int j = 0; j < 5; j++) {
                  		System.out.println(c.get());
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
						c.put("contaner value" + j);
					}
				}
			}, "producer" + i).start();
		}
	}
}
