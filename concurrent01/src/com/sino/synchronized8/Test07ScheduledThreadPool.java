package com.sino.synchronized8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test07ScheduledThreadPool {
    public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
		System.out.println(service);
		
		//定时完成任务 scheduleAtFixedRate(Runable, start_limit, limit, timeUnit)
		//Runable 要执行的任务 start_limit 第一次任务执行的间隔 limit 多次任务执行的间隔 timeUnit多次任务执行间隔的时间单位
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
