package com.mine.practice.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {	
	public static void main(String[] args) {
		
		List<ExampleObject> list= new ArrayList<ExampleObject>();
		
		list.add(new ExampleObject(10));
		list.add(new ExampleObject(11));
		list.add(new ExampleObject(12));
		list.add(new ExampleObject(9));
		
		Collections.sort(list, new Comparator<ExampleObject>() {
			@Override
			public int compare(ExampleObject o1, ExampleObject o2) {
				return ((ExampleObject)o1).getAge()-((ExampleObject)o2).getAge();
			}
			
		});
		

		list.forEach((ex)->{
			System.out.println(ex.getAge());
		});
		
		list.sort((ExampleObject o1,ExampleObject o2)->o2.getAge()-o1.getAge());
		
		list.forEach((ex)->{
			System.out.println(ex.getAge());
		});
		
		
	}
}


class ExampleObject{
	ExampleObject(int age){
		this.age=age;
	}
	private int age;
	public int getAge() {
		return age;
	}
	
}