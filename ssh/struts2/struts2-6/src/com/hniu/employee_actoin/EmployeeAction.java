package com.hniu.employee_actoin;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

public class EmployeeAction implements RequestAware {
	private Map requestMap;
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String show() {
		requestMap.put("show", Dao.getEmployee());
		return "show";
	}

	public String edit() {
		requestMap.put("edit", Dao.editEmployee(employee.getEmployeeId()));
		return "edit";
	}

	public String delete() {
		Dao.deleteEmployee(employee.getEmployeeId());
		return "delete";
	}

	public String add() {
		if (employee != null) {
			Dao.addEmployee(employee);
			return show();
		}
		return "add";
	}

	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}
}
