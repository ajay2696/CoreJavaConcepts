package com.mine.practice.threads;

public class ThreadDeadLockExample {

	public static void main(String[] args) throws InterruptedException {
		Object obj1 =new Object();
		Object obj2 =new Object();
		
		
		Thread t1= new Thread(new Runnable() {
			public void run() {
				synchronized (obj1) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (obj2) {
						System.out.println("--Print Value from Thread 1--");
					}
				}
			}			
		});
		
		Thread t2 =new Thread(new Runnable() {
			public void run() {
				synchronized (obj2) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (obj1) {
						System.out.println("--Print Value from Thread 2--");
					}
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("----Execution is Completed----");

	}

}
