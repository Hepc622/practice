package com.hniu.practice;

public class Department {
	private Integer departmentId;
	private String departmentName;

	public Department(Integer departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Department() {
		super();
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
