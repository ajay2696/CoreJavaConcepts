package com.mine.practice.threads;
 
/* Since the data is being changed  parallel we should make sure one thread completes execution and let other thread go into execution
 * we have to put the increment operations in synchronized blocks hence only one thread can access it
 *   Synchronized keyword can be used with Method or block
 * */
public class ThreadRaceConditionSolution {

	public static void main(String[] args) throws InterruptedException {
		Counter1 c=new Counter1();
		
		Runnable r1=new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<=1000;i++) {
					c.incrementCount();
						}				
					}			
				};
		Runnable r2=new Runnable() {
					@Override
					public void run() {
						for(int i=0;i<=1000;i++) {
							c.incrementCount();
								}				
							}
					
						};
		
	    Thread t1=new Thread(r1);
	    Thread t2=new Thread(r2);
	    t1.start();
	    t2.start();
	    t1.join();
	    t2.join();
	    System.out.println("---Get Value Of I--"+c.getI());
	    System.out.println("---Get Value of J--"+c.getJ());		

	}
	
	

}
/* We are going to use Synchronized Block for this example */
class Counter1{
	private int i=0;
	private int j=0;
	private Integer increment1=new Integer(1);
	private Integer increment2=new Integer(2);	
	public void incrementCount() {
		synchronized (increment1) {
			this.i++;
		}
		synchronized (increment2) {
		    this.j++;	
		}
	}
	public int getI() {
		return this.i;
	}
	public int getJ() {
		return this.j;
	}
	
}
