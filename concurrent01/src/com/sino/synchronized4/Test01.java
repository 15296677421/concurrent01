package com.sino.synchronized4;

import java.util.concurrent.TimeUnit;
/**
 * ThreadLocal
  *   就是一个Map.key ->Thread.getCurrentThread(). value ->线程需要保存的变量
 *  ThreadLocal.set(value) -> map.put(Thread.getCurrentThread(), value);
 *  ThreadLocal.get() -> map.get(Thread.getCurrentThread());
 *  1 内存问题：在并发量高的时候，可能有内存溢出。
 *  ThreadLocal.remove(); 使用ThreadLocal的时候，一定要注意资源回收问题，每个线程结束之前，将当前线程保存的线程变量一定要删除。
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
