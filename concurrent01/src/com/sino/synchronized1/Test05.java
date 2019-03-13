package com.sino.synchronized1;

import java.util.concurrent.TimeUnit;

public class Test05 {
    private double d = 0.0;
    
    public synchronized void m1 (double d) {
    	try {
    		TimeUnit.SECONDS.sleep(2);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	this.d = d;
    }
    
    public double m2() {
    	return this.d;
    }
    
    public static void main(String[] args) {
    	final Test05 t = new Test05();
    	
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.m1(100);
			}
		}).start();
    	System.out.println(t.m2());
    	try {
    		TimeUnit.SECONDS.sleep(3);
    	} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	System.out.println(t.m2());
    }
}
