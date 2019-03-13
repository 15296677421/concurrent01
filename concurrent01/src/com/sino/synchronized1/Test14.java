package com.sino.synchronized1;
/**
 * synchronized�ؼ���
 * ��������
 * �ڶ���ͬ�������ʱ����Ҫʹ�ó���������Ϊ��Ŀ�����
 */
public class Test14 {
    String s1 = "hello";
    String s2 = "hello";//new�ؼ��� һ�����ڶ��д���һ���µĶ���
    void m1() {
    	synchronized (s1) {
			System.out.println("m1()");
			while(true) {
				
			}
		}
    }
    
    void m2() {
    	synchronized (s2) {
    		System.out.println("m2()");
			while(true) {
				
			}	
		}
    }
    
    public static void main(String[] args) {
		final Test14 t = new Test14();
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
