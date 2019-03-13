package com.sino.synchronized1;
/**
 * synchronized�ؼ���
 * ͬ�������ͷ�ͬ�������ĵ���
 * ͬ��������Ӱ�������̵߳���ͬһ��ͬ������ʱ�������⡣
 */
public class Test04 {
	Object o = new Object();
    public synchronized void m1() {
    	System.out.println("public public synchronized void m1() start");
    	try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	System.out.println("public public synchronized void m1() and");
    }
    
    public void m3() {
    	synchronized (o) {
    		System.out.println("public void m3() strat");
        	try {
        		Thread.sleep(1500);
        	} catch (InterruptedException e){
        		e.printStackTrace();
        	}
        	System.out.println("public void m3() end");
		}
    	
    }
    
    public void m2() {
    	System.out.println("public void m2() strat");
    	try {
    		Thread.sleep(1500);
    	} catch (InterruptedException e){
    		e.printStackTrace();
    	}
    	System.out.println("public void m2() end");
    }
    
    public static class MyThread01 implements Runnable{
    	public MyThread01(int i, Test04 t) {
    		this.i = i;
    		this.t = t;
    	}
    	int i;
    	Test04 t;
		@Override
		public void run() {
            if(i == 0) {
            	t.m1();
            } else if(i ==1) {
            	t.m2();
            } else {
            	t.m3();
            }
		}
    }
    
    public static void main(String[] args) {
    	Test04 t = new Test04();
    	new Thread(new Test04.MyThread01(0, t)).start();
    	new Thread(new Test04.MyThread01(1, t)).start();
    	new Thread(new Test04.MyThread01(2, t)).start();
    }

}
