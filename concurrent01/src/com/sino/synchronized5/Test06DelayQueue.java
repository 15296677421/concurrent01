package com.sino.synchronized5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Test06DelayQueue {
    static BlockingQueue<MyTask06> queue = new DelayQueue<>();
    
    public static void main(String[] args) throws InterruptedException {
		long value = System.currentTimeMillis();
		
		MyTask06 task1 = new MyTask06(value + 2000);
		MyTask06 task2 = new MyTask06(value + 1000);
		MyTask06 task3 = new MyTask06(value + 3000);
		MyTask06 task4 = new MyTask06(value + 2500);
		MyTask06 task5 = new MyTask06(value + 1500);
		
		queue.put(task1);
		queue.put(task2);
		queue.put(task3);
		queue.put(task4);
		queue.put(task5);
		
		System.out.println(queue);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(queue.take());
		}
		
	}
}
class MyTask06 implements Delayed{
	
	private long compareValue;
	
	public MyTask06(long comparevalue) {
		this.compareValue = comparevalue;
	}
    /**
     * 1�Ƚϴ�С���Զ�ʵ������
     * 2�����getDelay���������� 
     * 3�����DelayQueues����Ҫ��ʱ����ɵļƻ����񣬱������getDelay�������
     */
	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
	}
    /**
     *1 ��ȡ�ƻ�ʱ���ķ�����
     *2 ���ݲ���TimeUnit����������η��ؽ��ֵ��    
     */
	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(compareValue - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	@Override
	public String toString() {
		return "task compare value is : " + this.compareValue ;
	}
	
	
}