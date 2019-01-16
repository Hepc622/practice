package com.hniu.ssh.service;

import java.util.List;

import com.hniu.ssh.dao.DepartmentDao;
import com.hniu.ssh.entities.Department;

public class DepartmentService {
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public List<Department> getDepartmentAll(){
		return this.departmentDao.getDepartmentAll();
	}
}
