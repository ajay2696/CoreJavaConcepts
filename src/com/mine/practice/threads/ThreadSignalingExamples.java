package com.mine.practice.threads;

/*-- We will create Two Thread one for reading the value and other for writing value-- After Reading the value it will Notify the other Thread */

public class ThreadSignalingExamples {

public static void main(String[] args) throws InterruptedException {
	ThreadSignal ts=new ThreadSignal();
	Thread t1= new Thread(new Runnable() {

		@Override
		public void run() {
			try {
			for(int i=0;i<10;i++) {
				ts.incrementValue();
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	});
	
	Thread t2= new Thread(new Runnable() {

		@Override
		public void run() {

			for(int i=0;i<10;i++) {
				try {
					ts.readValue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	});

	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println("----Threads Execution is Completed--");
}
}

class ThreadSignal{
	private int i=0;
	private boolean valueRead=true;
	public void incrementValue() throws InterruptedException {
	 synchronized(this){
				if(valueRead=false) {
					wait();
				}
				
				i++;	
				valueRead=false;				
				notify();
				
				
			}
	    Thread.sleep(100);
		
		}
	
	
	public void readValue() throws InterruptedException {
		synchronized (this) {
		  if(valueRead==true) {
			  wait();
			 }			
			valueRead =true;	
			System.out.println("Value has been Read--"+this.i+Thread.currentThread());
			notify();
			
		  
		}
	}
}
