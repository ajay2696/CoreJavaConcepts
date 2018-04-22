package com.mine.practice.basic;

/* String Pool: List of String Objects, if you create String using literal then it will first check the string pool and return the reference
 * If you create string using new then it will be created as new object*/
/* If you use String.intern() then Object will be created in String pool and return reference*/
/* If you do subString then it is is going to create new String using Character set*/
public class StringExamples {
	public static void main(String[] args) {
		String s="Ajay";
		String s1=new String("Ajay");
		String s3="Ajay";
		if(s==s1) {
			System.out.println("Both are same");
		}
		if(s==s3) {
			System.out.println("s and s3 are same");
		}
		String s4="Ajay";
		if(s1.intern()==s4.intern()) {
			System.out.println("--Since we used inter() both S1 and S4 should be equal");
		}
		
		
	}
}
