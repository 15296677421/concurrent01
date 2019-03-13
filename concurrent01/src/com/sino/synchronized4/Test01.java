package com.sino.synchronized4;

import java.util.concurrent.TimeUnit;
/**
 * ThreadLocal
  *   ����һ��Map.key ->Thread.getCurrentThread(). value ->�߳���Ҫ����ı���
 *  ThreadLocal.set(value) -> map.put(Thread.getCurrentThread(), value);
 *  ThreadLocal.get() -> map.get(Thread.getCurrentThread());
 *  1 �ڴ����⣺�ڲ������ߵ�ʱ�򣬿������ڴ������
 *  ThreadLocal.remove(); ʹ��ThreadLocal��ʱ��һ��Ҫע����Դ�������⣬ÿ���߳̽���֮ǰ������ǰ�̱߳�����̱߳���һ��Ҫɾ����
 *  
 */
public class Test01 {
    volatile static String name = "zhangsan";
    static ThreadLocal<String> tl = new ThreadLocal<String>();
    
    public static void main(String[] args) {
    	new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name);
				System.out.println(tl.get());
			}
		}).start();
    	
    	new Thread(new Runnable() {
			@Override
			public void run() {
                try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
                name = "lisi";
                tl.set("wangwu");
			}
		}).start();
    }
}
