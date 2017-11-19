package com.test.mvc;
public class Student {
	private String name;
	private Integer age;
	private String emill;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmill() {
		return emill;
	}
	public void setEmill(String emill) {
		this.emill = emill;
	}
	
	
	public Student( int id,String name, Integer age, String emill) {
		
		this.name = name;
		this.age = age;
		this.emill = emill;
		this.id = id;
	}
	public Student() {
	}

}
