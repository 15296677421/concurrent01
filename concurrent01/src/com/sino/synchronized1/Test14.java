package com.sino.synchronized1;
/**
 * synchronized关键字
 * 常量问题
 * 在定义同步代码块时，不要使用常量对象作为锁目标对象
 */
public class Test14 {
    String s1 = "hello";
    String s2 = "hello";//new关键字 一定是在堆中创建一个新的对象
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
