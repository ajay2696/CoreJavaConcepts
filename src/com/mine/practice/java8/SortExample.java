package com.mine.practice.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {

	public static void main(String[] args) {
		
		SortObject so1=new SortObject(10,"Nara");
		SortObject so2= new SortObject(12,"Ajay");
		SortObject so3= new SortObject(11,"Jay");
		
		List<SortObject> ls =new ArrayList<SortObject>();
		
		ls.add(so1);
		ls.add(so2);
		ls.add(so3);
		
		for(SortObject obj:ls) {
			System.out.println(obj.getId());
		}
		/*Collections.sort(ls,new Comparator<SortObject>() {
			@Override
			public int compare(SortObject obj1, SortObject obj2) {
				return obj1.getId()-obj2.getId();
			}
			
		});
		
		*/
		
		//Java 8 Way For Sorting the Data
		ls.sort((SortObject obj1,SortObject obj2) -> obj1.getId()-obj2.getId());

		ls.forEach((SortObject obj1)-> System.out.println(obj1.getId()));
		
		
	}

}

class SortObject{
	private int id;
	private String name;
	SortObject(int id, String name){
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}