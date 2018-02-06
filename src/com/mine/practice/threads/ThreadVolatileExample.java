package com.mine.practice.threads;

/*volatile keywork will make sure Changed value will be read from the Main Memory */
public class ThreadVolatileExample {
	
	private static volatile int counter=0;
	private static volatile boolean valueChanged =false;
	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();		
		
	}
	
	static class Thread1 extends Thread{
		@Override
		public void run() {
		 
		   for(int i=0;i<10;i++) {	
			   System.out.println("loop"+i);
			while(valueChanged==false) {
				valueChanged =true;
				counter++;
				System.out.println("Value CHanges--");				
			}

			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		}
	}
	
	static class Thread2 extends Thread{
		@Override
		public void run() {
		  for(int i=0;i<10;i++) {
		   while(valueChanged==true) {
			   valueChanged =false;
			   System.out.println("Changed Value---"+counter);
			}
		   
		   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

	   		
		}
	}
}
