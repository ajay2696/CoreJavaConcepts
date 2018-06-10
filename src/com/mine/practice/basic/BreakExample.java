package com.mine.practice.basic;

public class BreakExample {
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println("inside loop");
			if(i>5) {
				break;
			}
		}		
	}
}
