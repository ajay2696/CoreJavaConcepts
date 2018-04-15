package com.mine.practice.basic;
 class A {
   public int a=10;
   public void hello() {
	   System.out.println("Hello From Class A");
   }
 }
 
 class B extends A{
	 public int a=11;
	 public void hello() {
		 System.out.print("Hello from Class Bsss");
	 }
 }

public class Inheritance{
public static void main(String[] atgs) {
	A a=new B();	
	a.hello();
	System.out.println(a.a);	
}
}
