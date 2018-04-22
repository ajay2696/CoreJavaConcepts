package com.mine.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMap {
	public static void main(String[] args) {
		List<SortObject> list=Arrays.asList(
				new SortObject(1,"Ajay"),
				new SortObject(2,"Nara")
				);
		
		List<SortObject> filterList=list.stream().filter(obj-> ((SortObject)obj).getId()==1).collect(Collectors.toList());
		
		System.out.println(filterList.size());
		
		for(SortObject obj:filterList)
		{
			System.out.println(obj.getName());
		}
		
		filterList.forEach(obj->{System.out.println(((SortObject)obj).getName()
						);});
	}

}
