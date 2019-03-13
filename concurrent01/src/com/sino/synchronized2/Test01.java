package com.sino.synchronized2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
		final Test01Container t = new Test01Container();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
                for(int i = 0; i < 10 ;i++) {
                	System.out.println("add Object to Contaier" + i);
                	t.add(new Object());
                	try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                } 				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
            	while(true) {
            		if(t.size() == 5) {
            			System.out.println("size == 5");
            			break;
            		}
            	}			
			}
		}).start();
	}
}

class Test01Container {
	volatile List<Object> container = new ArrayList<Object>(); 
	
	public void add(Object o) {
		container.add(o);
	}
	
	public int size() {
		return container.size();
	}
}