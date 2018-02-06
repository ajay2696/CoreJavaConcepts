package com.mine.practice.threads;

public final class ImmutableObject {
	private final int age;
	private final String name;
	public ImmutableObject(int age,String name) {
		this.age=age;
		this.name =name;
	}
	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}
}
