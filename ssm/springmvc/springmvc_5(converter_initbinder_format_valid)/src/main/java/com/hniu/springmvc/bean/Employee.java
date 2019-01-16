package com.hniu.springmvc.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

/**
 * class：This is java bean of employee 
 * @author hpc
 * @2017年2月24日下午4:27:39
 */
@Component
public class Employee {
	@Length(max=5,min=3)
	private String name;
	@Range(max=130,min=16)
	private Integer age;
	@Length(max=1,min=1)
	private String sex;
	@Email
	private String email;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", sex=" + sex + ", email=" + email + "]";
	}
	public Employee() {
		super();
	}
	public Employee(String name, Integer age, String sex, String email) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
