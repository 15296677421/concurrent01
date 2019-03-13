package com.sino.synchronized5;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
/**
 * 并发容器 ConcurrentLinkedDeque
 * 底层是链表实现的
 *
 */
public class Test03ConcurrentLinkedQueue {
    public static void main(String[] args) {
		Queue<String> queue = new ConcurrentLinkedDeque<String>();
		for(int i = 0; i < 10; i++) {
			queue.offer("value" + i);
		}
		
		System.out.println(queue);
		System.out.println(queue.size());
		//peek()->查看queue中的首数据
		System.out.println(queue.peek());
		System.out.println(queue.size());
		//poll()->获取queue中的首数据
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}
}
