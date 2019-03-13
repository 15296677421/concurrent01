package com.sino.synchronized1;
/**
 * 
 * synchronized 关键字
 * 锁对象
 */
public class Test01 {
    private int count = 0;
    private Object o = new Object();
    
    //锁零阶资源对象
    public void testSync1() {
    	synchronized (o) {
			System.out.println(Thread.currentThread().getName() + "count =" + count++);
		}
    }
    
    //所当前对象
    public void testSync2() {
    	synchronized (this) {
    		System.out.println(Thread.currentThread().getName() + "count =" + count++);
		}
    }
    
    //锁当前对象
    public synchronized void testSync3() {
    	System.out.println(Thread.currentThread().getName() + "count =" + count++);
    }
} 
