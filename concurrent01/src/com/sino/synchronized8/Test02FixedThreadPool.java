package com.sino.synchronized8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1�̳߳�
 * 2�̶������̳߳�
 * 3FixedThreadPool - �̶������̳߳�.�����̳߳ص�ʱ�������̶��������ʱ���ṩ�̳߳�����
 * 4new xxxxx->
 * 5ExecutorService - �̳߳ط������͡����е��̳߳����Ͷ�ʵ��������ӿ�
 * 6ʵ������ӿڴ�������ṩ�̳߳�����
 * 8 shutdown - ���Źرգ�����ǿ�йر��̳߳ػ����̳߳��е���Դ�����ǲ��ٽ����µĴ������񣬽��ѽ��ܵ���������Ϻ��ٹرա�
 * 7Executors - Executor�Ĺ����ࡣ���Ը��򵥵Ĵ����������̳߳�
 */
public class Test02FixedThreadPool {
    public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 6; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
                    try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    System.out.println(Thread.currentThread().getName() + "- test executor");
				}
			});
		}
		
		System.out.println(service);
		
		service.shutdown();
		//�Ƿ��Ѿ��������൱�ڻ�������Դ
		System.out.println(service.isTerminated());
		//�Ƿ��Ѿ��رգ��Ƿ���ù�shutdown����
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
	}
}
