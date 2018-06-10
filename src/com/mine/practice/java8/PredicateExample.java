package com.mine.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*Predicate is a functional Interface. We can pass Lamda Expressions wherever predicate is expected*/
/*Predicate is also expression which evaluates to true or false*/

public class PredicateExample {
	public static Predicate<Employee> isIdGreaterThanTen(){
		return p->p.getId()>10;		
	}
	
	public static Predicate<Employee> isNameStartsWith(String prefix){
		return p->p.getEmployeeName().startsWith(prefix);
	}
	
	public static List<Employee> filterEmployees(List<Employee> list, Predicate<Employee> predicate) {
		return list.stream().filter(predicate).collect(Collectors.<Employee>toList());
		
	}
	
	public static void main(String[] args) {
		
		List<Employee> employees =new ArrayList<Employee>();
		employees.add(new Employee(10,"Ajay","PISCATAWAY"));
		employees.add(new Employee(11,"Nara","PISCATAWAY"));
		employees.add(new Employee(12,"Lucky","PISCATAWAY"));
		
		System.out.println(PredicateExample.filterEmployees(employees, PredicateExample.isIdGreaterThanTen()));	
		System.out.println(PredicateExample.filterEmployees(employees, PredicateExample.isNameStartsWith("A")));	
		
	}
}


