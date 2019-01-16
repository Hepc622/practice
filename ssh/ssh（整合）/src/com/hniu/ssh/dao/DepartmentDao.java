package com.hniu.ssh.dao;

import java.util.List;

import com.hniu.ssh.entities.Department;

public class DepartmentDao extends BaseDao {
	public List<Department> getDepartmentAll(){
		String hql="FROM Department";
		return getSession().createQuery(hql).list();
	}
}
