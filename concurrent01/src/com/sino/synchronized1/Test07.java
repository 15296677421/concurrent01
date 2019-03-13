package com.sino.synchronized1;

import java.util.concurrent.TimeUnit;
/**
 * synchronized关键字
 * 同步方法 继承
 * 子类同步方法覆盖父类同步方法。可以指定调用父类的同步方法
 * 相当于锁的重入
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