package com.mine.practice.java8;

import java.util.Arrays;
import java.util.List;

public class StreamFilters {
	
	public static void main(String[] args) {
		
		List<String> lines=Arrays.asList("Ajay","Nara","Lucky");
		
		String name=lines.stream().filter(obj ->((String)obj).equals("Lucky")).findFirst().orElse(null);
		
		System.out.println(name);
		lines.forEach(obj->System.out.println(obj));
	}

}
