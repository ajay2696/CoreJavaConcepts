package com.mine.practice.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServieThreadPoolExample {

	public static void main(String[] args) {
		
		ExecutorService executor=Executors.newFixedThreadPool(10);
		
		executor.submit(new Callable<Future>() {
			@Override
			public Future call() throws Exception {
				Thread.sleep(200);
				System.out.println("Callable Interface");
				return null;
			}
		});
		
		executor.submit(()->{System.out.println("----Arrow Function--");});
		
		executor.shutdown();
		
		while(!executor.isTerminated()) {
			//System.out.println("Executor is not terminated");
		}		
		
	}

}
