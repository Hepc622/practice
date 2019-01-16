package com.hniu.practice;

import java.util.ArrayList;
import java.util.List;

public class Dao {
	public static List<Department> getDepartment() {
		List<Department> list = new ArrayList<Department>();
		list.add(new Department(1, "销售部"));
		list.add(new Department(2, "业务部"));
		list.add(new Department(3, "开发部"));
		list.add(new Department(4, "设计部"));
		list.add(new Department(5, "人事部"));
		list.add(new Department(6, "财会部"));
		return list;
	}

	public static List<Role> getRole() {
		List<Role> list = new ArrayList<Role>();
		list.add(new Role(1, "Admin"));
		list.add(new Role(2, "Teacher"));
		list.add(new Role(3, "Employee"));
		return list;
	}
}
