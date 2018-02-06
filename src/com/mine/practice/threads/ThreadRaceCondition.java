package com.mine.practice.threads;
/* If One or More threads Access same resource and modify data then there is possibility if loosing the data.
 * 	Steps of Change Execution:- 
 * 		1.Load Variable from memory into PC Register
 * 		2.Increment variable in PC Register
 * 		3.Update memory location from PC Register
 *  Below is the Example of One such condition
 * */
public class ThreadRaceCondition {
	public static void main(String[] args) {
		Counter counter =new Counter();	
		Runnable r1= new Runnable() {
										@Override
										public void run() {
										  for(int i=0;i<1000;i++) {
											counter.incrementCount();
										  }
										}			
									 };
	   
		Runnable r2= new Runnable() {
										@Override
										public void run() {
											for(int i=0;i<1000;i++) {
											   counter.incrementCount();
											 }
											}			
										 };
										 
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("---Get the Count---"+counter.getCount());
		
		
	}
   }

class Counter{
	private int count=0;
	public void incrementCount() {
		this.count++;
	}
	public int getCount() {
		return this.count;
	}
}