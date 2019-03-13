package com.sino.synchronized1;

import java.util.concurrent.TimeUnit;
/**
 * volatile �ؼ���
 * volatile�Ŀɼ���
 * ֪ͨOS����ϵͳ�ײ㣬��CPU��������У���Ҫ����ڴ������ݵ���Ч�ԡ���֤���µ��ڴ����ݱ�ʹ��
 */
public class Test09 {
	/* volatile */ boolean b = true;
    void m() {
    	System.out.println("Start");
    	while(b) {}
    	System.out.println("end");
    }
    
    public static void main(String[] args) {
    	final Test09 t = new Test09();
    	
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.m();
			}
		}).start();
    	
    	try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	t.b = false;
    }
}
