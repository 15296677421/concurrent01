package com.sino.synchronized1;
/**
 * synchronized�ؼ���
 * ������������
 * ͬ������һ�������Ժ���ô����һ����ʱ��������ִ�������󣬺���ʵ��������ֱ�ӹ���
 * ����δ�ͷ�֮ǰ���޸����������ã�����Ӱ��ͬ�������ִ��
 */
import java.util.concurrent.TimeUnit;

public class Test13 {
    Object o = new Object();
    
    void m() {
    	System.out.println(Thread.currentThread().getName() + "start");
    	synchronized (o) {
			while(true) {
                try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}
		}
    }
    
    public static void main(String[] args) {
		final Test13 t = new Test13();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
                t.m();				
			}
		}, "thread1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
                t.m();				
			}
		},"theead2");
		t.o = new Object();
		thread2.start();
	}
}
