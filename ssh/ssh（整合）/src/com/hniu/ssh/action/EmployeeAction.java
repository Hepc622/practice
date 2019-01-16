package com.hniu.ssh.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.hniu.ssh.entities.Employee;
import com.hniu.ssh.service.DepartmentService;
import com.hniu.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware, Preparable, ModelDriven<Employee> {
	private EmployeeService employeeService;
	private Map<String, Object> request;
	private Integer id;
	private String name;
	private InputStream inputStream;
	private Employee model;
	private DepartmentService departmentService;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputstream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String userIsExist() {
		System.out.println(this.employeeService.userIsExist(name));
		if (this.employeeService.userIsExist(name)) {
			try {
				this.inputStream = new ByteArrayInputStream("1".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			try {
				this.inputStream = new ByteArrayInputStream("0".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajaxEmp";

	}

	public String addEmp() {
		request.put("departments", this.departmentService.getDepartmentAll());
		return "addEmp";
	}

	public String saveEmp() {
		this.employeeService.saveEmployee(model);
		return "saveEmp";
	}

	public void prepareSaveEmp() {
		if (id == null) {
			model = new Employee();
		} else {
			model = this.employeeService.getEmployeeById(id);
		}
	}

	public String editEmp() {
		this.addEmp();
		return "editEmp";
	}

	public void prepareEditEmp() {
		if (id == null) {
			model = new Employee();
		} else {
			model = this.employeeService.getEmployeeById(id);
		}

	}

	public String deleteEmp() {
		try {
			this.employeeService.deleteEmployee(id);
			this.inputStream = new ByteArrayInputStream("1".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				this.inputStream = new ByteArrayInputStream("0".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajaxEmp";
	}

	public String showEmp() {
		request.put("employees", this.employeeService.getEmployee());
		return "showEmp";
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	// 将model放入strus的栈顶，便于复制
	public Employee getModel() {
		return model;
	}

	public void prepare() throws Exception {
	}
}
