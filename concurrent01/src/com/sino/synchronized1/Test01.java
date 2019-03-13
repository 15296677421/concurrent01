package com.sino.synchronized1;
/**
 * 
 * synchronized �ؼ���
 * ������
 */
public class Test01 {
    private int count = 0;
    private Object o = new Object();
    
    //�������Դ����
    public void testSync1() {
    	synchronized (o) {
			System.out.println(Thread.currentThread().getName() + "count =" + count++);
		}
    }
    
    //����ǰ����
    public void testSync2() {
    	synchronized (this) {
    		System.out.println(Thread.currentThread().getName() + "count =" + count++);
		}
    }
    
    //����ǰ����
    public synchronized void testSync3() {
    	System.out.println(Thread.currentThread().getName() + "count =" + count++);
    }
} 
