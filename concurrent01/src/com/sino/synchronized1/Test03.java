package com.sino.synchronized1;
/**
 * synchronized关键字
 * 同步方法 - 原子性
 * 加锁的目：的就是为了保证操作的原子性
 */
public class Test03 implements Runnable {
    private int count = 0 ;

	@Override
	public /* synchronized */ void run() {
		System.out.println(Thread.currentThread().getName() + "count =" + count++);
	}
    
    public static void main(String[] args) {
    	Test03 t = new Test03();
    	for(int i = 0; i < 5; i++) {
    		new Thread(t, "Thread -" +1).start();
    	}
    }
}
