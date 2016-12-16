package com.jpa;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	private int age;
	private String name;
	@Id
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	public Student() {
		//super();
	}
	public Student(int age, String name) {
		//super();
		this.age = age;
		this.name = name;
	}
	

}
