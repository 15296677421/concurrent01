package com.sino.synchronized5;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
/**
 * �������� ConcurrentLinkedDeque
 * �ײ�������ʵ�ֵ�
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
		//peek()->�鿴queue�е�������
		System.out.println(queue.peek());
		System.out.println(queue.size());
		//poll()->��ȡqueue�е�������
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}
}
