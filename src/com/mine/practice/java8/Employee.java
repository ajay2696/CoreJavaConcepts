package com.mine.practice.java8;

public class Employee {
	private long id;
	public String employeeName;
	public String city;
	public Employee(long id,String employeeName,String city) {
		this.id=id;
		this.employeeName=employeeName;
		this.city=city;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;		
		
		if(obj.getClass()!=this.getClass()) {
			return false;
		}
		
		if(obj==this) {
			return true;
		}
		
		return this.getId()==((Employee)obj).getId();
		
	}
		
	@Override
	public int hashCode() {
		return (int) (31+this.id);
	}
	@Override
	public String toString() {
		return String.valueOf(this.getId());
	}
		
}
