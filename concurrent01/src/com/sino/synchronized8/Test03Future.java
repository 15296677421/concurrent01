package com.sino.synchronized8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Test03Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		 * FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
		 * 
		 * @Override public String call() throws Exception { return "first future task";
		 * } });
		 * 
		 * new Thread(task).start(); System.out.println(task.get());
		 */
		
		ExecutorService service = Executors.newFixedThreadPool(1);
		
		Future<String> future = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println("aaa");
				return Thread.currentThread().getName() + "- test executor";
			}
		});
		System.out.println(future);
		System.out.println(future.isDone());//查看线程是否结束，任务是否完成
		
		System.out.println(future.get());  //获取call方法的返回值
		System.out.println(future.isDone());
	}
}
