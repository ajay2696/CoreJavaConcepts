package com.mine.practice.threads;
/* To Verify this we need to create Object with method having local variables
 *  Try to Access these Variables from multiple threads and print the message of this object 
 *  In this Example, we have created multiple threads and accessed them from different Threads
 *    Since Each Thread will have their own call stack hence local variables are not shared and they are thread safe
 * */ 
public class ThreadSafeLocalVariablesCheck {	
	public static void main(String[] args) {
		LocalVariablesCheck lc=new LocalVariablesCheck();
		Runnable r=new Runnable() {
			@Override
			public void run() {
				lc.localVariableCheck();				
			}			
		};		
		new Thread(r,"Thread1").start();
		new Thread(r,"Thread2").start();
		
	}

}

class LocalVariablesCheck{
	public void localVariableCheck() {
		int i=0;
		for(;i<1000;) {
			i++;
		}
		System.out.println("-- Print i Value--"+Thread.currentThread().getName()+"---"+i);
	}
}
