package com.mine.practice.threads;

/* If we use the static object synchronized block then all the threads in JVM have to take slots one after another
 * 
 * */
public class ThreadSynchronizedStaticObjectMethod {
public static void main(String[] args) throws Exception {
	
	StaticObject obj1 =new StaticObject();
	Thread t1=new Thread(new Runnable() {
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				obj1.incrementCounter();
			}
		}		
	}) ;
	
	Thread t2=new Thread(new Runnable() {
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				obj1.incrementCounter();
			}
		}		
	}) ;
	
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println("---Value Of the Object Counter--"+obj1.getCounter());
}
}


class StaticObject{
	private int counter=0;
	private static Object staticObject =new Object();
	public void incrementCounter() {
		synchronized (staticObject) {
			this.counter++;
		}
	}
	
	public int getCounter() {
		return this.counter;
	}
}