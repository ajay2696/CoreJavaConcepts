package com.mine.practice.basic;

/* Continue will skip statements after continue*/
public class ContinueExample {	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			if(i>5) {
					continue;				
			}
			System.out.println("hello");
		}
		
	}
}
