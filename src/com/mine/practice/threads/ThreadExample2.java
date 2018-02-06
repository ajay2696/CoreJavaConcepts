package com.mine.practice.threads;
 
public class ThreadExample2 {

	public static void main(String[] args) throws InterruptedException {
		Thread2 t1=new Thread2();
		t1.setName("--Thread1--");
		t1.start();
		for(int i=0;i<=10;i++) {
			System.out.println("---Print All the Values from Main Thread--");
			Thread.sleep(1000);
		}
	}

}

class Thread2 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("---Print Values From Thread1--");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}