package com.sino.synchronized8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test07ScheduledThreadPool {
    public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
		System.out.println(service);
		
		//��ʱ������� scheduleAtFixedRate(Runable, start_limit, limit, timeUnit)
		//Runable Ҫִ�е����� start_limit ��һ������ִ�еļ�� limit �������ִ�еļ�� timeUnit�������ִ�м����ʱ�䵥λ
		service.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}, 0, 300, TimeUnit.MILLISECONDS);
	}
}
