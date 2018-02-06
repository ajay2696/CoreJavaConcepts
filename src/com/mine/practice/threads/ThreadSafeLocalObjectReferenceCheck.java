package com.mine.practice.threads;
/* In This Example, We will create the object references in local scope of method and try to access them in threads */
public class ThreadSafeLocalObjectReferenceCheck {
	public static void main(String[] args) {
		LocalObjectReference lor=new LocalObjectReference();
		Runnable r1=new Runnable() {
			@Override
			public void run() {
				lor.localObjectReference();
			}			
		};
		 
		Thread t1=new Thread(r1,"Thread1");
		Thread t2=new Thread(r1,"Thread2");
		t1.start();
		t2.start();		
	}

}

class LocalObjectReference{
	private int i=10;
	public void localObjectReference() {
		LocalObjectReference lo1=new LocalObjectReference();
		
		System.out.println("---Object HashCode---"+lo1);
	}
}

