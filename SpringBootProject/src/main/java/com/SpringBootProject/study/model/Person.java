package com.SpringBootProject.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity //1
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
query = "select p from Person p where p.name=?1 and address=?2")
public class Person {
	
	@Id //2
	@GeneratedValue //3
	private Long id;
	
	@NotBlank(message="name不能为空")
	private String name;
	
	@NotNull(message="age不能为空")
	private int age;
	
	@NotBlank(message="address不能为空")
	private String address;
	
	
	
	public Person() {
		super();
	}
	public Person(Long id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
