package com.mine.practice.threads;

public class ThreadSynchronizedInstanceBlock {
	
	public static void main(String[] args) throws InterruptedException {
		InstanceBlock ib=new InstanceBlock();
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					ib.incrementValue();
				}
			}
			
		});
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					ib.incrementValue();
				}
			}
			
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(ib.getValue());
	}

}

class InstanceBlock{
	private int i=0;
	private Integer instanceObject=new Integer(1);
	public void incrementValue(){
		synchronized (instanceObject) {
			this.i++;
		}
	}	
	public int getValue() {
		return this.i;
	}
}