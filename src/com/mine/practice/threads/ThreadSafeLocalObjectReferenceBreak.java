package com.mine.practice.threads;
/* In This Example, We will create the object references in local scope of method and try to access them in threads */
public class ThreadSafeLocalObjectReferenceBreak {
	public static void main(String[] args) {
		LocalObjectReferenceBreak2 lob2 =new LocalObjectReferenceBreak2();
		LocalObjectReferenceBreak1 lob1 =new LocalObjectReferenceBreak1(lob2);
		
		Runnable r1=new Runnable() {
			@Override
			public void run() {
				lob1.localObjectReference();
			}			
		};
		

	 	Runnable r2=new Runnable() {
			@Override
			public void run() {
				lob2.increamentVariable();
			}			
		};
		
		Thread t1=new Thread(r1,"Thread1");
		Thread t2=new Thread(r2,"Thread2");
		t1.start();
		t2.start();		
	}

}

class LocalObjectReferenceBreak1{
	private int i=0;
	private LocalObjectReferenceBreak2 lob2;
	LocalObjectReferenceBreak1(){
	}
	LocalObjectReferenceBreak1(LocalObjectReferenceBreak2 lob2){
		this.lob2=lob2;
	}
	public void localObjectReference() {
		LocalObjectReferenceBreak1 lo1=new LocalObjectReferenceBreak1();
		lob2.setObjectReference(lo1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<2000;i++) {
			lo1.incrementValue();
		}
		System.out.println("---Object HashCode---"+lo1.i);
	}
	public void incrementValue() {
		this.i++;
	}
}
class LocalObjectReferenceBreak2{
	private LocalObjectReferenceBreak1 lref;
	public void setObjectReference(LocalObjectReferenceBreak1 lo1) {
		 this.lref=lo1;		 
	}
	public void increamentVariable() {
		int check=0;
		while(true && check==0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(lref!=null) {
				check=1;
				for(int i=0;i<1000;i++) {
					this.lref.incrementValue();
				}
			}
		}
	}
}

