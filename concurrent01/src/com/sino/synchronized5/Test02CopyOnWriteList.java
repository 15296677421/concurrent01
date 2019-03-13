package com.sino.synchronized5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class Test02CopyOnWriteList {
	public static void main(String[] args) {
	    final List<String> list = new ArrayList<String>();
	    //final List<String> list = new Vector<String>();
	    //final List<String> list = new CopyOnWriteArrayList<String>();
	    final Random r = new Random();
	    Thread[] array = new Thread[100];
	    final CountDownLatch latch = new CountDownLatch(array.length);
	    
	    long begin = System.currentTimeMillis();
	    for(int i = 0; i < array.length; i++) {
	    	array[i] = new Thread(new Runnable() {
				@Override
				public void run() {
                    for(int j = 0; j < 1000; j++) {
                    	list.add("value" + r.nextInt(100000));
                    }	
                    latch.countDown();
				}
			});
	    }
	    for(Thread t : array) {
	    	t.start();
	    }
	    try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    long end = System.currentTimeMillis();
	    System.out.println("ִ��ʱ��Ϊ" + (end-begin) + "����");
	    System.out.println("List.size()" + list.size());
	}

}
