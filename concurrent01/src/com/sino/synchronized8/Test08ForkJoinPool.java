package com.sino.synchronized8;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class Test08ForkJoinPool {
    final static int[] numbers = new int[1000000];
    final static int MAX_SIZE = 50000;
    final static Random r = new Random();
    
    static {
    	for(int i = 0; i < numbers.length; i++) {
    		numbers[i] = r.nextInt(1000);
    	}
    }
    
    static class AddTask extends RecursiveTask<Long> {
    	int begin;
    	int end;
    	public AddTask(int begin, int end) {
    		this.begin = begin;
    		this.end = end;
    	}
		@Override
		protected Long compute() {
        	if((end - begin) < MAX_SIZE) {
        		long sum = 0L;
        		for(int i =begin; i < end; i++) {
        			sum += numbers[i];
        		}
        		//System.out.println("from" + begin + "to" + end + " sum is : " + sum);
        		return sum;
        	} else {
        		int middle = begin + (end - begin)/2;
        		AddTask task1 = new AddTask(begin, middle);
        		AddTask task2 = new AddTask(middle, end);
        		task1.fork();//�������ڿ����µ�����ģ����Ƿ�֧�����ġ����ǿ���һ���µ��߳�����
        		task2.fork();
        		return task1.join() + task2.join();//join �ϲ���������Ľ����ȡ������һ������������һ����õ����ݽ��
        	}
		}
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
		Long result = 0L;
		for(int i = 0; i < numbers.length; i++) {
			result += numbers[i];
		}
		System.out.println(result);
		
		ForkJoinPool pool = new ForkJoinPool();
		AddTask task = new AddTask(0, numbers.length);
		
		Future<Long> future =pool.submit(task);
		System.out.println(future.get());
	}
}
