package com.mine.practice.basic;
/* 1. Finally will be Used with try and catch 
 * 2. Finally will be used to clean up resources like sessions etc
 * 3. Finally will run if exceptions or  if return statement runs before finally
 * */
public class FinallyBlockExample {

	public static void main(String[] args) {
		FinallyBlockExample fb =new FinallyBlockExample();
		fb.getValue();
		fb.getValue2();
	}
	/* Example one-- If Exception is Thrown then code in Finally Block will be executed*/
	public int getValue() {
		try {
			throw new Exception();
		} catch(Exception e) {
			e.printStackTrace();
		} 		
		finally {
			System.out.println("---Finally Block --");
		}
		
		return 2;
	}
	/*Example Two:-- Finally will be executed if it is returned also*/
	public int getValue2() {
		try {
			return 1;
		} catch(Exception e) {
			
		}
		finally {
			System.out.println("---Finally Block will be Executed After Return also");
		}
		
		return 2;
		
	}

}
