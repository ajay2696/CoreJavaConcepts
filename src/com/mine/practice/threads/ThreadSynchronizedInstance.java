package com.mine.practice.threads;
/* If We remove Synchronized From incrementCounter then t1 and t2 will increment values one by one
 * t1 and t2 are examples for this.
 * Lock will be acquired at Object level always, If There are two synchronized member methods and two threads are accessing 
 * */
public class ThreadSynchronizedInstance {
	public static void main(String[] args) throws InterruptedException {
		InstanceVariable iv1=new InstanceVariable();
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					iv1.incrementCounter();
				}
			}			
		});
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					iv1.incrementCounter();
				}
			}			
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("---Instance Variable---"+iv1.getCounter());
	}
}

class InstanceVariable{
	private int counter=0;
	public synchronized void incrementCounter() {
		this.counter++;
	}
	
	public int getCounter() {
		return this.counter;
	}
}