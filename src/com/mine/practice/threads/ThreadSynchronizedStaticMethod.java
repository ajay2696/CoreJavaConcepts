package com.mine.practice.threads;
/* If We remove Synchronized From incrementCounter then t1 and t2 will increment values one by one
 * t1 and t2 are examples for this.
 * Lock will be acquired at Object level always, If There are two synchronized member methods and two threads are accessing 1ethod1 and Method2. 
 *   Both t1 and t2 can access these only one at once.
 * */
public class ThreadSynchronizedStaticMethod {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					StaticClass.incrementCounter();
				}
			}			
		});
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					StaticClass.incrementCounter();
				}
			}			
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("---Static Variable---"+StaticClass.getCounter());
	}
}

class StaticClass{
	private static int counter=0;
	public static synchronized void incrementCounter() {
		counter++;
	}
	
	public static int getCounter() {
		return counter;
	}
}