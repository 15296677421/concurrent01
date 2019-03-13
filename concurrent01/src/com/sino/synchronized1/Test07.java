package com.sino.synchronized1;

import java.util.concurrent.TimeUnit;
/**
 * synchronized�ؼ���
 * ͬ������ �̳�
 * ����ͬ���������Ǹ���ͬ������������ָ�����ø����ͬ������
 * �൱����������
 */
public class Test07 {
    synchronized void m1() {
    	System.out.println("super calss m start");
        try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("super calss m end");
    }
    
    public static void main(String[] args) {
    	new SubTest07().m1();
    }
}

class SubTest07 extends Test07 {
	synchronized void m1() {
		System.out.println("sub class m start");
		super.m1();
		System.out.println("sub class m end");
	}
}