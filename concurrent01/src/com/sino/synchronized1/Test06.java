package com.sino.synchronized1;

import java.util.concurrent.TimeUnit;
/**
 * synchronized关键字
 * 同步方法 - 调用其他同步方法
 * 锁可重入。同一个线程，多次调用同步代码
 */
public class Test06 {
    synchronized void m1() {
    	System.out.println("m1() start");
    	try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	m2();
    	System.out.println("m1() end");
    }
    
    synchronized void m2() {
    	System.out.println("m2 start");
    	try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("m2 end");
    }
    
    public static void main(String[] args) {
    	new Test06().m1();
    }
}
