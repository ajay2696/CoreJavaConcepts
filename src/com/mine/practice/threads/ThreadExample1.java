package com.mine.practice.threads;

/* This is the First Example of thread-- We can start thread by passing Runnable class to Thread Constructor and Start
 * We can create subclasses from Thread
 * */
public class ThreadExample1 {

	public static void main(String[] args) {
		Thread t1=new Thread(new Thread1());
		t1.start();
		for(int i=0;i<=10;i++) {
			System.out.println("--Print All the Values From Calling Thread--");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("--Print All the Values from Child Thread--");
		}
	}
	
}