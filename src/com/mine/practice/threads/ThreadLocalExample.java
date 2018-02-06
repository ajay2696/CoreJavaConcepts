package com.mine.practice.threads;
/* In the Below Example, We have created single runnable instance and passing it to two different Threads, we are setting the instance variable in run class,
 * If it is not ThreadLocal then print from both the threads should have printed same value*/
public class ThreadLocalExample {

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalRunnable runnable=new ThreadLocalRunnable();
		Thread t1=new Thread(runnable);
		Thread t2=new Thread(runnable);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	

	static class ThreadLocalRunnable implements Runnable{
		ThreadLocal<String> variable=new ThreadLocal<String>();
		@Override
		public void run() {
			 variable.set(Double.toString(Math.random()));	
			 System.out.println("Values are Set");
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 System.out.println("--Print Values--"+variable.get());
		}
		
		
	}
	

}


