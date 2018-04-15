package com.mine.practice.basic;

/* If you want to make Object Immutable then Make setters as private and Object varibles as final, So you dont change the state by error*/
/* Immutable objects make better Keys for HashMap*/
/* */
public class ImmutableObjectExample {
	ImmuntableObject1 ib= new ImmuntableObject1(1,2);
	
}

final class ImmuntableObject1{
	final private int i;
	final private int j;
	
	ImmuntableObject1(int i,int j){
		this.i=i;
		this.j=j;
	}
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	
}
