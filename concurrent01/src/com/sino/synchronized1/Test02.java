package com.sino.synchronized1;
/**
 * synchronized关键字
 * 同步方法 - static
 * 静态同步方法，锁的是当前类型的类对象。在本代码中就是Test02.class
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
