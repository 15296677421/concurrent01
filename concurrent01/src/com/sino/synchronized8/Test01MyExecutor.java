package com.sino.synchronized8;

import java.util.concurrent.Executor;

/**
 * 1�̳߳�
 *   Executor - �̳߳صײ㴦����ơ�
 *   2��ʹ���̳߳ص�ʱ�򣬵ײ���ε����߳��е��߼���
 *
 */
public class Test01MyExecutor implements Executor {
    public static void main(String[] args) {
		new Test01MyExecutor().execute(new Runnable() {
			@Override
			public void run() {
                System.out.println(Thread.currentThread().getName() + "- test executor");				
			}
		});
	}
	@Override
	public void execute(Runnable command) {
        new Thread(command).start();		
	}
  
}
