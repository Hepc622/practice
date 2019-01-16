package com.hniu.ssh.service;

import java.util.List;

import com.hniu.ssh.dao.EmployeeDao;
import com.hniu.ssh.entities.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	/**
	 * 获取employee对象
	 * @return 返回employee对象
	 */
	public List<Employee> getEmployee(){
		return this.employeeDao.getEmployee();
	}
	/**
	 * 保存对象数据
	 * @param employee保存对象保存起来
	 */
	public void saveEmployee(Employee employee){
		this.employeeDao.saveEmployee(employee);
	}
	/**
	 * 删除对象
	 * @param id删除数据
	 */
	public void deleteEmployee(int id) {
		this.employeeDao.deleteEmployee(id);
	}
	/**
	 * 判断该用户是否可用
	 * @param name 通过name查询是否存在该用户
	 * @return 返回employee实例
	 */
	public boolean userIsExist(String name) {
		 return this.employeeDao.userIsExist(name)==null;
	}
	/**
	 * 通过指定id获取数据
	 * @param id 通过id查询数据库数据
	 * @return 返回employee对象
	 */
	public Employee getEmployeeById(Integer id) {
		return this.employeeDao.getEmployeeById(id);
	}
}
