package com.mine.practice.basic;


public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowClone sc= new ShallowClone(10,12);
		ShallowClone sc1= (ShallowClone) sc.clone();
		System.out.println(sc1.getI());
		
	}

}

class ShallowClone implements Cloneable {
	private int i;
	private int j;
	public ShallowClone(int i, int j) {
		this.i=i;
		this.j=j;
	}
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}