package com.mine.practice.exceptions;
/*  Finally Block will be used with try-catch block, If there is any exception thrown then also it will be executed
 *  If there is any Return in try also, finally block will be executed
 * */

public class FinallyBlockTest {

private int getMessage() {
	try {
	//return 1;
	throw new Exception("Exception");	
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		System.out.println("Finally Block is Executed");
	}
	return 0;
}

public static void main(String[] args) {
	FinallyBlockTest obj=new FinallyBlockTest();
	System.out.println(obj.getMessage());
}
}

