package com.sino.synchronized1;
/**
 * synchronized�ؼ���
 * ͬ����������
 * ��������ҵ�����б���ʹ��ͬ��������ʹ��ͬ������顣ϸ����ͬ�����⡮
 * �������Ч��
 */
public class Test12 {
    synchronized void m1() {
    	//ǰ���߼�
    	System.out.println("ͬ���߼�");
    	//�����߼�
    }
    
    void m2() {
    	//ǰ���߼�
    	synchronized (this) {
    		System.out.println("ͬ���߼�");
    	}
    	//�����߼�
    }
}
