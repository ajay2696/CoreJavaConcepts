package com.mine.practice.java8;

import java.util.HashMap;
import java.util.Map;

public class MapSortExample {

	public static void main(String[] args) {
		Map<Integer,String> hs=new HashMap<Integer,String>();
		hs.put(1, "ajay");
		hs.put(2, "nara");
		hs.forEach((k,v)->{
			System.out.println(k+"-----------"+v);
		});
		
		SortObject so1= new SortObject(1,"Ajay");
		SortObject so2 =new SortObject(2,"Nara");
		
		Map<Integer,SortObject> hs2=new HashMap<Integer,SortObject>();
		hs2.put(1, so1);
		hs2.put(2, so2);
		
		hs2.forEach((k,v)->{
			System.out.println(k+"---------"+((SortObject)v).getName());
		});
		
	}

}
