package com.sino.synchronized1;
/**
 * synchronized�ؼ���
 * ͬ������ - �����쳣
 * ��ͬ�������з����쳣��ʱ���Զ��ͷ�����Դ������Ӱ�������̵߳�ִ��
 * ע�⣺ ͬ��ҵ���߼��У���������쳣��δ���
 */
import java.util.concurrent.TimeUnit;

public class Test08 {
    int i = 0;
    synchronized void m() {
    	System.out.println(Thread.currentThread().getName() + "- start");
    	while(1 == 1) {
    		i++;
    		System.out.println(Thread.currentThread().getName() + "-" +i);
    		try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(i == 5) {
    			i = 1/0;
    		}
    	}
    }
    
    public static void main(String[] args) {
    	final Test08 t = new Test08();
    	
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
               t.m();				
			}
		}, "t1").start();
    	
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.m();
			}
		}, "t2").start();
    }
}
