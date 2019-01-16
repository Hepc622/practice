package com.hniu.employee_actoin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Dao {
	private static Map<Integer, Employee> employees = new LinkedHashMap<Integer, Employee>();
	private static List<Employee> list;
	static {
		employees.put(1, new Employee(1, "AA", "aa"));
		employees.put(2, new Employee(2, "BB", "bb"));
		employees.put(3, new Employee(3, "CC", "cc"));
		employees.put(4, new Employee(4, "DD", "dd"));
		employees.put(5, new Employee(5, "EE", "ee"));
		employees.put(6, new Employee(6, "FF", "ff"));
	}

	public static List<Employee> getEmployee() {
		list = new ArrayList<Employee>(employees.values());
		return list;
	}

	public static void deleteEmployee(Integer key) {
		employees.remove(key);
	}

	public static Employee editEmployee(Integer key) {
		return employees.get(key);
	}

	public static void addEmployee(Employee value) {
		Employee employee = list.get(list.size() - 1);
		Integer id = employee.getEmployeeId();
		++id;
		value.setEmployeeId(id);
		employees.put(id, value);
	}
}
