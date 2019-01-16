package com.hniu.ssh.entities;

import java.util.Date;

public class Employee {
	private Integer employee_id;
	private String employee_name;
	private String employee_email;
	private Date employee_date;
	private Department dep_id;
	
	public Department getDep_id() {
		return dep_id;
	}
	public void setDep_id(Department department_id) {
		this.dep_id = department_id;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	public Date getEmployee_date() {
		return employee_date;
	}
	public void setEmployee_date(Date employee_date) {
		this.employee_date = employee_date;
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_email="
				+ employee_email + ", employee_date=" + employee_date + ", department_id=" + dep_id+ "]";
	}
	
}
