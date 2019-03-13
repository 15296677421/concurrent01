package com.sino.synchronized8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test05CachedThreadPool {
    public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
		
		for(int i = 0; i < 5; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
                    try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
                    System.out.println(Thread.currentThread().getName() + " - test executor ");
				}
			});
		}
		System.out.println(service);
		try {
			TimeUnit.SECONDS.sleep(65);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(service);
	}
}
