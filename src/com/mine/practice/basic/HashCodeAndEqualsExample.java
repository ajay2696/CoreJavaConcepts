package com.mine.practice.basic;

/* 1. Why HashCode and Equals()
 * 2. Why Java Doc Says we need to override both hashcode and equals() 
 *  Answers: When you compare object equality by using ==, it will check for hashcode equilance.
 *  While adding objects to hashmap, first it will check hashcode and find the hashbucket- If hashcodes are same then it will check objects
 *  by equals method,If both are same then replace else add it to the linked list.
 * 3. Object Reference and Object Hashcode are different.  Object reference is pointer to the object
 *    Default Object.eqauls method checks the memory address equality of both objects
 * 
 *  If your overriding Equals Then you should override hashcode method also.
 * */

public class HashCodeAndEqualsExample {

	public static void main(String[] args) {
		Employee e =new Employee(10);
		Employee e1= new Employee(10);
		System.out.println(e.hashCode());
		System.out.print(e.equals(e1));
	}

}

class Employee{
	private int i;
	public Employee(int i){
		this.i=i;
	}
	public int getI() {
		return i;
	}

	@Override
	public int hashCode() {
		return i;
		
	}
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(o==this) {
			System.out.println("This and That Are Same");
			return true;
		}
		if(o.getClass()!=getClass()) {
			return false;
		}
		Employee e=(Employee)o;
		if(e.getI()== this.getI()) {
			return true;
		}
		return true;		
	}
}
