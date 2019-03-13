package com.sino.synchronized1;
/**
 * synchronized�ؼ���
 * ͬ������ - static
 * ��̬ͬ�������������ǵ�ǰ���͵�������ڱ������о���Test02.class
 *
 */
public class Test02 {
    private static int staticCount = 0;
    
    public static synchronized void testSync4() {
    	System.out.println(Thread.currentThread().getName() + "staticCount" + staticCount++);
    }
    
    public static void testStnc5() {
    	synchronized(Test02.class) {
    		System.out.println(Thread.currentThread().getName() + "staticCount" + staticCount++);
    	}
    	
    }
}
