package com.sino.synchronized2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test03 {
    public static void main(String[] args) {
		final Test03Container t = new Test03Container();
		final CountDownLatch latch = new CountDownLatch(1);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
                if(t.size() != 5) {
                	try {
						latch.await();//等待门闩的开放。
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }	
                System.out.println("size = 5");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("add Object to Container" + i);
					t.add(new Object());
					if(t.size() == 5) {
						latch.countDown();
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}

class Test03Container {
    List<Object> container = new ArrayList<Object>(); 
	
	public void add(Object o) {
		container.add(o);
	}
	
	public int size() {
		return container.size();
	}
}